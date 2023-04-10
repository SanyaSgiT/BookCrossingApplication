package com.example.bookcrossingapplication.ui.booklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookcrossingapplication.data.repository.BookRepository
import com.example.bookcrossingapplication.domain.Book
import kotlinx.coroutines.launch

class BookListViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    init {
        viewModelScope.launch {
            _books.postValue(bookRepository.getAllBooks())
        }
    }

    fun search(query: String) {
        viewModelScope.launch {
            val result = if (query.isBlank()) {
                bookRepository.getAllBooks()
            } else {
                bookRepository.findBooksByTitle(query)
            }

            _books.postValue(result)
        }
    }
}