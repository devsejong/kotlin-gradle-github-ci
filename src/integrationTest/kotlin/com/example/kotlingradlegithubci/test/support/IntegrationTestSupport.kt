package com.example.kotlingradlegithubci.test.support

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest

@EnableAutoConfiguration
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.NONE,
    classes = [IntegrationTestConfig::class],
)
internal annotation class IntegrationTestSupport
