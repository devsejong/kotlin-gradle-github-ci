package com.example.kotlingradlegithubci.task

import com.example.kotlingradlegithubci.test.support.IntegrationTestSupport
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize

@IntegrationTestSupport
class TaskServiceTest(
    private val taskRepository: TaskRepository
) : FunSpec({
    lateinit var taskService: TaskService

    beforeTest {
        taskService = TaskService(taskRepository)
    }

    test("aaa") {
        taskRepository.saveAll(listOf(Task(name = "aaaa"), Task(name = "bbbb")))

        taskService.getAll() shouldHaveSize 2
    }
})
