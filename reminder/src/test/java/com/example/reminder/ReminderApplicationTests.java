package com.example.reminder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import tech.powerjob.client.PowerJobClient;
import tech.powerjob.common.enums.DispatchStrategy;
import tech.powerjob.common.enums.ExecuteType;
import tech.powerjob.common.enums.ProcessorType;
import tech.powerjob.common.enums.TimeExpressionType;
import tech.powerjob.common.model.LifeCycle;
import tech.powerjob.common.request.http.SaveJobInfoRequest;
import tech.powerjob.common.response.JobInfoDTO;
import tech.powerjob.common.response.ResultDTO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class ReminderApplicationTests {

    @Test
    void contextLoads() {
//        System.out.println("ds");
        PowerJobClient client = new PowerJobClient("127.0.0.1:7700", "root", "123456");
//        ResultDTO<JobInfoDTO> jobInfoDTOResultDTO = client.fetchJob(721040532851130432L);
//        System.out.println(jobInfoDTOResultDTO.getMessage());
        // 创建一个 SaveJobInfoRequest 对象，包含所有必填和可选参数
        SaveJobInfoRequest request = new SaveJobInfoRequest();

        // 设置任务 ID（创建任务时为 null）
        request.setId(null);

        // 设置任务名称
        request.setJobName("Data Processing Task");

        // 设置任务描述
        request.setJobDescription("This job processes data on a regular schedule.");

        // 设置任务参数（JobParams 是 TaskContext 对象的 jobParams 字段）
        Map<String, Object> jobParams = new HashMap<>();
        jobParams.put("param1", "value1");
        jobParams.put("param2", "value2");
        // 使用 Jackson ObjectMapper 将 jobParams 转为 JSON 字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jobParamsJson = objectMapper.writeValueAsString(jobParams);
            request.setJobParams(jobParamsJson);  // 设置为 JSON 格式的字符串
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 设置时间表达式类型（如 CRON，FIXED_RATE 等，假设这里是 CRON）
        request.setTimeExpressionType(TimeExpressionType.CRON);

        // 设置时间表达式（如 cron 表达式 "0 0 * * *" 每小时执行一次）
        request.setTimeExpression("*/5 * * * * ?");

        // 设置执行类型（如 STANDALONE 或 MAP_REDUCE）
        request.setExecuteType(ExecuteType.STANDALONE);

        // 设置处理器类型（如 JAVA，SHELL，HTTP）
        request.setProcessorType(ProcessorType.BUILT_IN);

        // 设置处理器参数（如 Java 处理器的全限定类名）
        request.setProcessorInfo("testProcessor");

        // 设置最大实例数
        request.setMaxInstanceNum(5);

        // 设置单机线程并发数
        request.setConcurrency(3);

        // 设置任务实例运行时间限制（0 代表无限制）
        request.setInstanceTimeLimit(0L);

        // 设置任务实例重试次数
        request.setInstanceRetryNum(2);

        // 设置每个 Task 的重试次数
        request.setTaskRetryNum(3);

        // 设置最小可用 CPU 核心数
        request.setMinCpuCores(2);

        // 设置最小内存大小（单位 GB）
        request.setMinMemorySpace(1);

        // 设置最小磁盘空间（单位 GB）
        request.setMinDiskSpace(10);

        // 设置指定执行任务的 Worker 机器（可选，空表示不指定机器）
        request.setDesignatedWorkers(null);

        // 设置最大执行机器数量
        request.setMaxWorkerCount(2);

        // 设置接收报警的用户 ID 列表
        request.setNotifyUserIds(Arrays.asList(101L, 102L));

        // 设置是否启用任务
        request.setEnable(true);

        // 设置调度策略（随机或者健康度优先）
        request.setDispatchStrategy(DispatchStrategy.RANDOM);

        // 设置任务生命周期（预留字段）
        request.setLifeCycle(LifeCycle.parse("2024-01-01T00:00:00Z~2024-12-31T23:59:59Z"));

        // 设置扩展字段（开发者可自行使用）
//        Map<String, String> extra = new HashMap<>();
//        extra.put("customField1", "customValue1");
//        request.setExtra(extra);

        // 调用保存任务接口
        ResultDTO<Long> result = client.saveJob(request);

        // 根据 result 判断是否成功创建任务
        if (result.isSuccess()) {
            System.out.println("任务创建成功，任务ID：" + result.getData());
        } else {
            System.out.println("任务创建失败，错误信息：" + result.getMessage());
        }
    }
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("d","ds");
        Object o = redisTemplate.opsForValue().get("d");
        redisTemplate.opsForValue().set("name", "www", 5, TimeUnit.SECONDS);
        System.out.println(o);
    }



}
