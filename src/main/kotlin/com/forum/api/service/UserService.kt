package com.forum.api.service

import com.forum.api.model.User
import com.forum.api.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class UserService(
    private val userRepository: UserRepository,
){

    fun searchById(id: Long): User {
        return userRepository.findById(id).get()
    }
}