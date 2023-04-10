package com.example.bookcrossingapplication.data.service.model

import com.example.bookcrossingapplication.domain.Book
import kotlinx.serialization.Serializable

@Serializable
data class BooksResponse(
    val books: List<Book>
)