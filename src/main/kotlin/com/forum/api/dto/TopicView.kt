package com.forum.api.dto

import com.forum.api.model.enums.StatusTopic
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val createTime: LocalDateTime,
)
