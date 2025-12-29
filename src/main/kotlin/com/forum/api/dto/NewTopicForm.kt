package com.forum.api.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewTopicForm(
    @field:NotEmpty(message = "Title should not be empty")
    @field:Size(min = 5, max = 100, message = "The title should have between 5 and 100")
    val title: String,
    @field:NotEmpty(message = "Message should not be empty")
    val message: String,
    @field:NotNull
    val idCourse: Long,
    @field:NotNull
    val idAuthor: Long
)
