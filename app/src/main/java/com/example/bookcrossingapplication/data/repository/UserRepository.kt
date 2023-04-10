package com.example.bookcrossingapplication.data.repository

import com.example.bookcrossingapplication.data.api.UserApi
import com.example.bookcrossingapplication.domain.User

class UserRepository(private val api: UserApi) {
    suspend fun findUserById(id: Int): User? = api.getUser(id)
}