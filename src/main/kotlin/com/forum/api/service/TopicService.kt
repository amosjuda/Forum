package com.forum.api.service

import com.forum.api.dto.NewTopicForm
import com.forum.api.dto.TopicView
import com.forum.api.dto.UpdateTopicForm
import com.forum.api.exception.NotFoundException
import com.forum.api.mapper.TopicFormMapper
import com.forum.api.mapper.TopicViewMapper
import com.forum.api.model.Topic
import com.forum.api.repository.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topicRepository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    fun list(): List<TopicView> {
        return topicRepository.findAll().map { topicViewMapper.map(it) }
    }

    fun searchById(id: Long): TopicView {
        val topic = topicRepository.findById(id)
            .orElseThrow { NotFoundException("Topic not found") }
        return topicViewMapper.map(topic)
    }

    fun register(form: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topicRepository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        val topic = topicRepository.findById(form.id)
            .orElseThrow { NotFoundException("Topic not found") }
        topic.title = form.title
        topic.message = form.message
        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
        topicRepository.deleteById(id)
    }
}
