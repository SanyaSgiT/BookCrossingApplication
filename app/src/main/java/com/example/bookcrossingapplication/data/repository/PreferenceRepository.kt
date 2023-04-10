package com.example.bookcrossingapplication.data.repository

import android.content.SharedPreferences
import androidx.core.content.edit

class PreferenceRepository(private val sharedPreferences: SharedPreferences) {
    var firstLaunch: Boolean
        get() = sharedPreferences.getBoolean(::firstLaunch.name, true)
        set(value) {
            sharedPreferences.edit {
                putBoolean(::firstLaunch.name, value)
            }
        }
}