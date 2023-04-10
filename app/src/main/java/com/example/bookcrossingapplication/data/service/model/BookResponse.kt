package com.example.bookcrossingapplication.data.service.model

import com.example.bookcrossingapplication.domain.Genre
import com.example.bookcrossingapplication.domain.User
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val genre: Genre,
    val author: String,
    val user: User
)