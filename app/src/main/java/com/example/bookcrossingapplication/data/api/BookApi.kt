package com.example.bookcrossingapplication.data.api

import com.example.bookcrossingapplication.data.service.model.BookResponse
import com.example.bookcrossingapplication.data.service.model.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookApi {
    @GET("books")
    suspend fun getAllBooks(): BooksResponse

    @GET("books/{id}")
    suspend fun getBook(@Path("id") id: Int): BookResponse

    @GET("books")
    suspend fun findBooksByTitle(@Query("query") query: String): BooksResponse

    @GET("books/owner/{id}")
    suspend fun findBooksByOwnerId(@Path("id") id: Int): BooksResponse
}