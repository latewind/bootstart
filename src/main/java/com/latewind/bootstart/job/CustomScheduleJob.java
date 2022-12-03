package com.latewind.bootstart.job;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.latewind.bootstart.config.ThreadPools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;

/**
 * 客制任务调度配置
 *
 * @author latewind
 */
@Configuration
public class CustomScheduleJob implements SchedulingConfigurer {


    private static final Logger log = LoggerFactory.getLogger(CustomScheduleJob.class);

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        // 任务线程池
        taskRegistrar.setScheduler(ThreadPools.getExecutorService());
        // 任务调度内容、任务调度周期
        TriggerTask trigger = new TriggerTask(new Runnable() {
            @Override
            public void run() {
                log.debug("CustomScheduleJob run");
            }
        }, new CronTrigger("0/10 * * * * ?"));

        taskRegistrar.addTriggerTask(trigger);

    }

}
