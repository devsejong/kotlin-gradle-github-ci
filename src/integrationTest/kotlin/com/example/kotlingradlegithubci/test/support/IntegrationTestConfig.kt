
package com.example.kotlingradlegithubci.test.support

import com.example.kotlingradlegithubci.KotlinGradleGithubCiApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [KotlinGradleGithubCiApplication::class])
class IntegrationTestConfig
