package com.gupao.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Quartz测试
 */
@Slf4j
public class QuartzTest {
    static  Logger logger = LoggerFactory.getLogger(QuartzTest.class);
    public static void main(String[] args) {
        log.info("====start");
        logger.info("====");
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("trigger1","group1")
                    .build();

            //cron表达式
            CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
            //构建触发器实例
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(cronSchedule)
                    .build();
            scheduler.scheduleJob(jobDetail,trigger);
            System.out.println("======end");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

}
