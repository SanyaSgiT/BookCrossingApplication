package com.example.bookcrossingapplication.ui.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookcrossingapplication.data.repository.BookRepository
import com.example.bookcrossingapplication.domain.Book
import com.example.bookcrossingapplication.domain.User
import kotlinx.coroutines.launch

class BookViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {
    private val _book = MutableLiveData<Data>()
    val book: LiveData<Data> = _book

    fun requestBook(id: Int) {
        viewModelScope.launch {
            val bookResponse = bookRepository.findBookById(id)

            with(bookResponse) {
                _book.postValue(
                    Data(
                        Book(
                            id, user.id, title, description, imageUrl, genre, author
                        ),
                        bookResponse.user
                    )
                )
            }
        }
    }

    data class Data(
        val book: Book,
        val user: User
    )
}