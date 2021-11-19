package com.example.kotlingradlegithubci

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@SpringBootApplication
class KotlinGradleGithubCiApplication

fun main(args: Array<String>) {
    runApplication<KotlinGradleGithubCiApplication>(*args)
}
