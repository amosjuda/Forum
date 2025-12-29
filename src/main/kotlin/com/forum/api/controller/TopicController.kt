package com.forum.api.controller

import com.forum.api.dto.NewTopicForm
import com.forum.api.dto.TopicView
import com.forum.api.dto.UpdateTopicForm
import com.forum.api.service.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(
    private val topicService: TopicService
) {

    @GetMapping
    fun list(): List<TopicView> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long): TopicView {
        return topicService.searchById(id)
    }

    @PostMapping
    @Transactional
    fun register(
        @RequestBody @Valid form: NewTopicForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = topicService.register(form)
        val uri = uriBuilder.path( "/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid form: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = topicService.update(form)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }
}