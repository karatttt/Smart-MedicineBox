package com.example.reminder.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.example.reminderJob.api.ReminderJobServiceGrpc;
import com.smb.GrpcParams;
import com.smb.SmbServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import okhttp3.FormBody;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.powerjob.client.TypeStore;
import tech.powerjob.common.enums.TimeExpressionType;
import tech.powerjob.common.exception.PowerJobException;
import tech.powerjob.common.model.LifeCycle;
import tech.powerjob.common.response.ResultDTO;
import tech.powerjob.common.utils.CommonUtils;
import tech.powerjob.common.utils.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/client")
public class TestController {
    //注入阻塞型的gRPC调用对象，服务调用的地址在application.yml中设置了
    @GrpcClient("grpc-server")
    private SmbServiceGrpc.SmbServiceBlockingStub blockingStub;
    @GrpcClient("grpc-server")
    private ReminderJobServiceGrpc.ReminderJobServiceBlockingStub blockingStub2;
    //注入异步调用的gRPC调用对象
    @GrpcClient("grpc-server")
    private SmbServiceGrpc.SmbServiceFutureStub futureStub;
    //创建一个线程池来进行异步调用
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20,
            0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(50), new ThreadPoolExecutor.CallerRunsPolicy());
    //用来接收异步调用结果
    private String result;

    /**
     * 测试阻塞调用
     *
     * @return 调用结果
     */
    @GetMapping("/block")
    public String block() {
        //构造请求对象
        GrpcParams.MedicineReq helloRequest = GrpcParams.MedicineReq.newBuilder().setMedicineId(1).build();
        //进行阻塞式地调用
        GrpcParams.MedicineResponse helloResponse = blockingStub.getMedicineInfo(helloRequest);
        return helloResponse.getDescription();
    }
    @GetMapping("/block2")
    public int block2() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("127.0.0.1:7700");
        Long appId = getAppId(strings, "root", "123456");
        //构造请求对象
       com.example.reminderJob.protos.GrpcParams.ReminderJobReq reminderJobReq= com.example.reminderJob.protos.GrpcParams.ReminderJobReq.newBuilder()
               // 设置任务 ID（创建任务时为 null）
               .setId(String.valueOf("")) // 假设用 0 表示 null
               .setAppId(appId)

               // 设置任务名称
               .setJobName("Data Processing Task")

               // 设置任务描述
               .setJobDescription("This job processes data on a regular schedule.")

               // 设置任务参数（将 jobParams 转为 JSON 字符串）
               .setJobParams("") // 确保这里 jobParamsJson 是 JSON 字符串

               // 设置时间表达式类型（假设这里是 CRON）
               .setTimeExpressionType(com.example.reminderJob.protos.GrpcParams.TimeExpressionType.CRON)

               // 设置时间表达式（每 5 分钟执行一次）
               .setTimeExpression("*/5 * * * * ?")

               // 设置执行类型
               .setExecuteType(com.example.reminderJob.protos.GrpcParams.ExecuteType.STANDALONE)

               // 设置处理器类型
               .setProcessorType(com.example.reminderJob.protos.GrpcParams.ProcessorType.BUILT_IN)

               // 设置处理器参数
               .setProcessorInfo("testProcessor")

               // 设置最大实例数
               .setMaxInstanceNum(5)

               // 设置单机线程并发数
               .setConcurrency(3)

               // 设置任务实例运行时间限制（0 代表无限制）
               .setInstanceTimeLimit(0L)

               // 设置任务实例重试次数
               .setInstanceRetryNum(2)

               // 设置每个 Task 的重试次数
               .setTaskRetryNum(3)

               // 设置最小可用 CPU 核心数
               .setMinCpuCores(2)

               // 设置最小内存大小（单位 GB）
               .setMinMemorySpace(1)

               // 设置最小磁盘空间（单位 GB）
               .setMinDiskSpace(10)

               // 设置指定执行任务的 Worker 机器（可选，空表示不指定机器）
               //.setDesignatedWorkers("") // 如果没有指定，设置为空字符串

               // 设置最大执行机器数量
               .setMaxWorkerCount(2)

               // 设置接收报警的用户 ID 列表
               .addAllNotifyUserIds(Arrays.asList(101L, 102L))

               // 设置是否启用任务
               .setEnable(true)

               // 设置调度策略
               .setDispatchStrategy(com.example.reminderJob.protos.GrpcParams.DispatchStrategy.RANDOM)

               // 设置任务生命周期（预留字段）
               //.setLifeCycle(LifeCycle.parse("2024-01-01T00:00:00Z~2024-12-31T23:59:59Z"))

               .build(); // 构建请求对象
        com.example.reminderJob.protos.GrpcParams.ReminderJobResponse helloResponse = blockingStub2.addReminderJob(reminderJobReq);
        return helloResponse.getId();
    }

    private Long getAppId(List<String> addressList, String appName, String password) {
        CommonUtils.requireNonNull(addressList, "addressList can't be null!");
        CommonUtils.requireNonNull(appName, "appName can't be null");
//        this.allAddress = addressList;
        Iterator var4 = addressList.iterator();
        Long appId = 0L;
        while(var4.hasNext()) {
            String addr = (String)var4.next();
            String url = getUrl("/assert", addr);

            try {
                String result = assertApp(appName, password, url);
                if (StringUtils.isNotEmpty(result)) {
                    ResultDTO<Long> resultDTO = (ResultDTO) JSON.parseObject(result, TypeStore.LONG_RESULT_TYPE, new Feature[0]);
                    if (!resultDTO.isSuccess()) {
                        throw new PowerJobException(resultDTO.getMessage());
                    }

                     appId = (Long)resultDTO.getData();
//                    this.currentAddress = addr;
                    break;
                }
            } catch (IOException var9) {
            }
        }
        return appId;

    }
    private static String getUrl(String path, String address) {
        return String.format("http://%s%s%s", address, "/openApi", path);
    }
    private static String assertApp(String appName, String password, String url) throws IOException {
        FormBody.Builder builder = (new FormBody.Builder()).add("appName", appName);
        if (password != null) {
            builder.add("password", password);
        }

        return HttpUtils.post(url, builder.build());
    }
}
