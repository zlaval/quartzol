package com.zlrx.example.quatzol.job

import com.zlrx.example.quatzol.service.SimpleService
import org.quartz.DisallowConcurrentExecution
import org.quartz.Job
import org.quartz.JobExecutionContext

@DisallowConcurrentExecution
class FastJob(
    private val service: SimpleService
) : Job {

    override fun execute(context: JobExecutionContext?) {
        val key = context?.jobDetail?.key?.name ?: "No key"
        service.printData(key)
    }
}