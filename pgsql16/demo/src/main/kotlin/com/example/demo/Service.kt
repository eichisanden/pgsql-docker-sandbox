package com.example.demo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service(val repository: Repository) {
    @Transactional(readOnly = true)
    fun find(): String {
        return repository.find()
    }

    @Transactional
    fun update(): String {
        return repository.update()
    }
}