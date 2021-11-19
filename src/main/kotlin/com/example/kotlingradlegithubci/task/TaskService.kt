package com.example.kotlingradlegithubci.task

import org.springframework.stereotype.Service

@Service
class TaskService(val taskRepository: TaskRepository) {
    fun getAll(): List<Task> {
        return taskRepository.findAll()
    }
}
