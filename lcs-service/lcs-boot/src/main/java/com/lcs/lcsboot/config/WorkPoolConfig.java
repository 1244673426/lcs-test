package com.lcs.lcsboot.config;//package com.pos.posboot.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.ThreadPoolExecutor;
//
///**
// * @author Curtain
// * @date 2021/11/1
// */
//@Configuration
//public class WorkPoolConfig {
//
//    @Value(value ="4")
//    private Integer workPoolCoreSize;
//
//    @Value("4")
//    private Integer workPoolMaxSize;
//
//    @Value("${settings.work-pool.queue-capacity}")
//    private Integer queueCapacity;
//
//    @Bean("workPoolScheduler")
//    public ThreadPoolTaskExecutor taskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(workPoolCoreSize);
//        executor.setMaxPoolSize(workPoolMaxSize);
//        executor.setQueueCapacity(queueCapacity);
//        executor.setKeepAliveSeconds(60);
//        executor.setThreadNamePrefix("-device-");
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.setAwaitTerminationSeconds(60);
//        return executor;
//    }
//}
//
