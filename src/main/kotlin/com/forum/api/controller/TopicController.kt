package com.forum.api.controller

import com.forum.api.model.Topic
import com.forum.api.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(
    private val topicService: TopicService
) {

    @GetMapping
    fun list(): List<Topic> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long): Topic {
        return topicService.searchById(id)
    }

}