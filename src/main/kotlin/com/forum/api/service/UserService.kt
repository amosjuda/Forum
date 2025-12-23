package com.forum.api.service

import com.forum.api.model.User
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class UserService(
    var users: List<User>
){
    init {
        val user = User(
            id = 1,
            name = "Kotlin",
            email = "ana@email"
        )
        users = Arrays.asList(user)
    }

    fun searchById(id: Long): User {
        return users.stream().filter({
                c -> c.id == id
        }).findFirst().get()
    }
}