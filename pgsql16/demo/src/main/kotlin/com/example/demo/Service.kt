package com.example.demo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service(val repository: Repository) {
    @Transactional
    fun hello(): String {
        return repository.hello()
    }
}