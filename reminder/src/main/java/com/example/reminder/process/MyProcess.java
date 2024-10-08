package com.example.reminder.process;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;
import tech.powerjob.worker.log.OmsLogger;

@Slf4j
@Component(value = "testProcessor")
public class MyProcess implements BasicProcessor {
    @Override
    public ProcessResult process(TaskContext context) throws Exception {
        OmsLogger omsLogger = context.getOmsLogger();
        omsLogger.info("处理器启动成功，context 是 {}.", context);
        log.info("单机处理器正在处理");
        log.info(context.getJobParams());
        omsLogger.info("用户:" + context.getJobParams() + "该吃药啦！");
        System.out.println("用户:" + context.getJobParams()+ "该吃药啦！");
        boolean success = true;
        return new ProcessResult(success, context + ": " + success);
    }
}