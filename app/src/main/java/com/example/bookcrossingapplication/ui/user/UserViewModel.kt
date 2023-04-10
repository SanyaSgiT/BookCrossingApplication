package com.example.bookcrossingapplication.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookcrossingapplication.data.repository.BookRepository
import com.example.bookcrossingapplication.data.repository.UserRepository
import com.example.bookcrossingapplication.domain.Book
import com.example.bookcrossingapplication.domain.User
import kotlinx.coroutines.launch

class UserViewModel(
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    private val _books = MutableLiveData<Data>()
    val books: LiveData<Data> = _books

    fun requestBooks(id: Int) {
        viewModelScope.launch {
            _books.postValue(
                Data(
                    userRepository.findUserById(id) ?: error("No such user"),
                    bookRepository.findBooksByOwnerId(id)
                )
            )
        }
    }

    data class Data(
        val user: User,
        val books: List<Book>
    )
}