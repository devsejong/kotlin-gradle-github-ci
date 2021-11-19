package com.example.kotlingradlegithubci.task

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String,

)
