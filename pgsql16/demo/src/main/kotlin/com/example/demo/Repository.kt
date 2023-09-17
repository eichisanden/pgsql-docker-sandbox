package com.example.demo

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.io.IOException

@Repository
class Repository(val jdbcTemplate: JdbcTemplate) {
    fun find(): String {
        val value = jdbcTemplate.queryForObject("SELECT 1", Int::class.java)
        return "result: $value"
    }

    //@Throws(IOException::class)
    fun update(): String {
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS test (id INT)")
        val ret = jdbcTemplate.update("INSERT INTO test (id) VALUES (1)")
        if (ret == 1)
            throw IOException("rollback")
        return "updated"
    }
}