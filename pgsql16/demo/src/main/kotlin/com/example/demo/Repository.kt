package com.example.demo

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class Repository(val jdbcTemplate: JdbcTemplate) {
    fun find(): String {
        val value = jdbcTemplate.queryForObject("SELECT 1", Int::class.java)
        return "result: $value"
    }

    fun update(): String {
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS test (id INT)")
        jdbcTemplate.update("INSERT INTO test (id) VALUES (1)")
        return "updated"
    }
}