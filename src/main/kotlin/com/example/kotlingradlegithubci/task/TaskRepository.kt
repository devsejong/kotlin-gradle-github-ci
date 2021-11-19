package com.example.kotlingradlegithubci.task

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task, Long>
