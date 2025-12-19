package com.forum.api.service

import com.forum.api.model.Author
import com.forum.api.model.Course
import com.forum.api.model.Topic
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class TopicService(
    private var topics: List<Topic>
) {
    init {
        val topic1 = Topic(
            id = 1,
            title = "Kotlin doubt",
            description = "Kotlin variable",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "programming"
            ),
            author = Author(
                id = 1,
                name = "Ana da silva",
                email = "ana@gmail.com"
            )
        )
        val topic2 = Topic(
            id = 2,
            title = "Kotlin doubt",
            description = "Kotlin variable",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "programming"
            ),
            author = Author(
                id = 1,
                name = "Ana da silva",
                email = "ana@gmail.com"
            )
        )
        val topic3 = Topic(
            id = 3,
            title = "Kotlin doubt",
            description = "Kotlin variable",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "programming"
            ),
            author = Author(
                id = 1,
                name = "Ana da silva",
                email = "ana@gmail.com"
            )
        )
        topics = Arrays.asList(topic1, topic2, topic3)
    }

    fun list(): List<Topic> {
        return topics
    }

    fun searchById(id: Long): Topic {
        return topics.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }
}