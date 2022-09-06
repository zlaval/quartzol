package com.zlrx.example.quatzol.service

import org.springframework.stereotype.Service

@Service
class SimpleService {

    fun printData(key: String) {

        // println("$key job runs from service starts $uuid")
        Thread.sleep(1000)
        println("$key job runs from service finish")
    }

}