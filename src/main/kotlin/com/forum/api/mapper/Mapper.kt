package com.forum.api.mapper

interface Mapper<T, U> {
    fun map(model: T): U
}