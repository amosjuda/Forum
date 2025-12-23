package com.forum.api.model

import com.forum.api.model.enums.StatusTopic

data class Answers(
    val id: Long? = null,
    val message: String,
    val creationDate: String,
    val course: Course,
    val author: User,
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val answers: List<Answers> = ArrayList(),
)
