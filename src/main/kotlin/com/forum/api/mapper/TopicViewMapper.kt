package com.forum.api.mapper

import com.forum.api.dto.TopicView
import com.forum.api.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            createTime = t.createTime,
        )
    }
}