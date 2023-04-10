package com.example.bookcrossingapplication.di

import android.content.Context
import com.example.bookcrossingapplication.data.api.BookApi
import com.example.bookcrossingapplication.data.api.UserApi
import com.example.bookcrossingapplication.data.repository.BookRepository
import com.example.bookcrossingapplication.data.repository.PreferenceRepository
import com.example.bookcrossingapplication.data.repository.UserRepository
import com.example.bookcrossingapplication.ui.book.BookViewModel
import com.example.bookcrossingapplication.ui.booklist.BookListViewModel
import com.example.bookcrossingapplication.ui.user.UserViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {
    factory { PreferenceRepository(androidApplication().getSharedPreferences("prefs", Context.MODE_PRIVATE)) }
    factory { BookRepository(get()) }
    factory { UserRepository(get()) }
}

val presentationModule = module {
    viewModel { BookViewModel(get()) }
    viewModel { BookListViewModel(get()) }
    viewModel { UserViewModel(get(), get()) }
}

val networkModule = module {
    factory {
        val contentType = MediaType.parse("application/json")!!

        Retrofit.Builder()
            .baseUrl("http://37.194.210.121:4721/")
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    factory { get<Retrofit>().create(UserApi::class.java) }
    factory { get<Retrofit>().create(BookApi::class.java) }
}