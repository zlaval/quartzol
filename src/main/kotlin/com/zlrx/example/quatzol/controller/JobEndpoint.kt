package com.zlrx.example.quatzol.controller

import com.zlrx.example.quatzol.job.FastJob
import org.quartz.JobBuilder
import org.quartz.Scheduler
import org.quartz.SimpleScheduleBuilder
import org.quartz.TriggerBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.concurrent.ThreadLocalRandom


@RestController
class JobEndpoint(
    private val scheduler: Scheduler
) {


    @GetMapping("fastjob")
    fun startFastJob() {
        val uuid = UUID.randomUUID().toString()
        val job = JobBuilder.newJob(FastJob::class.java)
            .withIdentity("threeSecJob $uuid")
            .usingJobData("jobKey", uuid)
            .build()

        val trigger = TriggerBuilder.newTrigger()
            .withIdentity("threeSecScheduler $uuid")
            .startNow()
            .withPriority(ThreadLocalRandom.current().nextInt(0, 10))
            .withSchedule(
                SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(3)
                    .withMisfireHandlingInstructionFireNow()
                    .repeatForever()
            )
            .build()

        scheduler.scheduleJob(job, trigger)
    }


}