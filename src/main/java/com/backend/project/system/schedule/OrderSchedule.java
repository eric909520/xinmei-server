package com.backend.project.system.schedule;

import com.backend.framework.config.ThreadPoolConfig;
import com.backend.project.system.mapper.AppConfigMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

/**
 * 订单相关计划
 */
@Configuration
@EnableScheduling
@Slf4j
public class OrderSchedule {

    @Resource
    private ThreadPoolConfig threadPoolConfig;
    @Resource
    private AppConfigMapper appConfigMapper;

    /**
     */
//    @Scheduled(fixedDelay = 60000L)
    private void preOrderTask() {
        threadPoolConfig.threadPoolExecutor().submit(() -> {
//            log.info("===== 提前生成预支付订单任务启动 =====");
        });
    }

}
