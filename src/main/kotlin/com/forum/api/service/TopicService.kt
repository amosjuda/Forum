package com.forum.api.service

import com.forum.api.dto.NewTopicForm
import com.forum.api.dto.TopicView
import com.forum.api.dto.UpdateTopicForm
import com.forum.api.exception.NotFoundException
import com.forum.api.mapper.TopicFormMapper
import com.forum.api.mapper.TopicViewMapper
import com.forum.api.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
        private var topics: List<Topic> = ArrayList(),
        private val topicViewMapper: TopicViewMapper,
        private val topicFormMapper: TopicFormMapper
) {

    fun list(): List<TopicView> =
        topics.map { topic -> topicViewMapper.map(topic) }

    fun searchById(id: Long): TopicView {
        val topic = topics.firstOrNull { t -> t.id == id }
            ?: throw NotFoundException("Topic not found")
        return topicViewMapper.map(topic)
    }

    fun register(form: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        val topic = topics.firstOrNull { t -> t.id == form.id }
            ?: throw NotFoundException("Topic not found")
        val updatedTopic = Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            author = topic.author,
            course = topic.course,
            status = topic.status,
            answers = topic.answers,
            createTime = topic.createTime,
        )
        topics = topics.minus(topic).plus(updatedTopic)
        return topicViewMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        val topic = topics.firstOrNull { t -> t.id == id }
            ?: throw NotFoundException("Topic not found")
        topics = topics.minus(topic)
    }
}
