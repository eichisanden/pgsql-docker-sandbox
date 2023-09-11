package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(val service: Service) {
    @GetMapping("/")
    fun index(): String {
        return service.find()
    }

    @GetMapping("/update")
    fun update(): String {
        return service.update()
    }
}