package com.example.bookcrossingapplication.data.service.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(val login: String, val password: String)
