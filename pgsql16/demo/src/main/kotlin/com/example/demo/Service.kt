package com.example.demo

import org.springframework.stereotype.Service

@Service
class Service(val repository: Repository) {
    @MyTransactional(readOnly = true)
    fun find(): String {
        return repository.find()
    }

    @MyTransactional
    fun update(): String {
        val ret = repository.update()
        return ret
    }
}