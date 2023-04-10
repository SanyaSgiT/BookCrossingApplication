package com.example.bookcrossingapplication.data.repository

import com.example.bookcrossingapplication.data.api.BookApi
import com.example.bookcrossingapplication.data.service.model.BookResponse
import com.example.bookcrossingapplication.domain.Book

class BookRepository(private val api: BookApi) {
    suspend fun getAllBooks(): List<Book> = api.getAllBooks().books

    suspend fun findBooksByTitle(title: String) = api.findBooksByTitle(title).books

    suspend fun findBooksByOwnerId(id: Int): List<Book> = api.findBooksByOwnerId(id).books

    suspend fun findBookById(id: Int): BookResponse = api.getBook(id)
}