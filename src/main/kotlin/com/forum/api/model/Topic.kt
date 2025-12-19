package com.forum.api.model

import com.forum.api.model.enums.StatusTopic
import java.time.LocalDateTime

data class Topic (
    val id: Long? = null,
    val title: String,
    val description: String,
    val createTime: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: Author,
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val answers: List<Answers> = ArrayList(),
)
