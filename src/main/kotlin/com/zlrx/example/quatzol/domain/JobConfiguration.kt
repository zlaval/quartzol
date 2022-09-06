package com.zlrx.example.quatzol.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class JobConfiguration(
    @Id
    val id: String
) {
    lateinit var name: String


}