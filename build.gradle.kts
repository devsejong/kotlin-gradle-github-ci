import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.spring") version "1.6.0"
    kotlin("plugin.jpa") version "1.6.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("mysql:mysql-connector-java")

    testImplementation("io.kotest:kotest-runner-junit5:4.6.0")
    testImplementation("io.kotest:kotest-assertions-core:4.6.0")
    testImplementation("io.kotest:kotest-assertions-json:4.6.0")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.0.0")

    testImplementation("io.mockk:mockk:1.11.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

sourceSets {
    create("integrationTest") {
        compileClasspath += sourceSets.main.get().output + sourceSets.test.get().output
        runtimeClasspath += sourceSets.main.get().output + sourceSets.test.get().output

        resources.srcDir(file("src/integrationTest/resources"))
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

task<Test>("integrationTest") {
    description = "Runs integration tests."
    group = "verification"

    testClassesDirs = sourceSets["integrationTest"].output.classesDirs
    classpath = sourceSets["integrationTest"].runtimeClasspath

    shouldRunAfter("test")
}

val integrationTestImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.implementation.get(), configurations.testImplementation.get())
}

tasks.check {
    dependsOn(":ktlintCheck")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
