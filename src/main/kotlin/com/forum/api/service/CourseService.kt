package com.forum.api.service

import com.forum.api.model.Course
import com.forum.api.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CourseService(
    private val courseRepository: CourseRepository,
){

    fun searchById(id: Long): Course {
        return courseRepository.findById(id).get()
    }
}