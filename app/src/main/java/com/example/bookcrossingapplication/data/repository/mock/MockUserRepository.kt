package com.example.bookcrossingapplication.data.repository.mock

import com.example.bookcrossingapplication.domain.User

class MockUserRepository {
    private val list = listOf(
        User(
            1,
            "still_little_child",
            "Саша Исаенко",
            "https://sun9-78.userapi.com/impg/1kJrKL7Fdmn274BxY6C9Tdi6YlJdg6n8kDd3kQ/VbkTzJS4tVQ.jpg?size=960x1280&quality=95&sign=c2cba7a4c7edc64c3b417a912762ec14&type=album",
            "https://t.me/still_little_child"
        ),
        User(
            2,
            "skpolechka",
            "Полина Скакалина",
            "https://sun4-10.userapi.com/impg/3wzQAMKWfaPyXKeMY5ugfo36s3_eqOtUcR-Mng/jzpjwDpJGdo.jpg?size=960x1280&quality=96&sign=b33de3b96948d7e5671d376e64596741&type=album",
            "https://t.me/skpolechka"
        )
    )

    fun findUserById(id: Int): User? = list.find { it.id == id }
}