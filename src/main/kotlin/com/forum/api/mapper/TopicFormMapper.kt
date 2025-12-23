package com.forum.api.mapper

import com.forum.api.dto.NewTopicForm
import com.forum.api.model.Topic
import com.forum.api.service.CourseService
import com.forum.api.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
): Mapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.searchById(t.idCourse),
            author = userService.searchById(t.idAuthor)
        )
    }
}