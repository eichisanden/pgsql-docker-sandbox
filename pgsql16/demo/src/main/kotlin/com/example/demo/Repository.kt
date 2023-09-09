package com.example.demo

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class Repository(val jdbcTemplate: JdbcTemplate) {
    fun hello(): String {
        val value = jdbcTemplate.queryForObject("SELECT 1", Int::class.java)
        return "result: $value"
    }
}