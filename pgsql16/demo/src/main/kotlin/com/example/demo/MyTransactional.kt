package com.example.demo

import org.springframework.core.annotation.AliasFor
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional(rollbackFor = [Exception::class])
annotation class MyTransactional(
    @get:AliasFor(annotation = Transactional::class, attribute = "readOnly")
    val readOnly: Boolean = false,

    @get:AliasFor(annotation = Transactional::class, attribute = "propagation")
    val propagation: Propagation = Propagation.REQUIRED
)
