package com.latewind.bootstart.job;

import groovy.lang.GroovyClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 静态定时任务
 *
 * @author latewind
 */
@Component
public class StaticScheduleJob {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 固定延迟
     */
    @Scheduled(fixedDelay = 50000)
    public void startJob() {
        logger.debug("start job delay {}", 50000);
    }

    /**
     * cron表达式
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void startJobCron() {
        GroovyClassLoader classLoader = new GroovyClassLoader();

        logger.debug("start job cron {}", "0/10 * * * * ?");
    }
}
