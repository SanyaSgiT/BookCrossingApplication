package com.example.bookcrossingapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bookcrossingapplication.data.repository.PreferenceRepository
import com.example.bookcrossingapplication.ui.account.LogInActivity
import com.example.bookcrossingapplication.ui.account.RegisterActivity
import com.example.bookcrossingapplication.ui.booklist.BookListActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var login: Button
    private lateinit var register: Button
    private lateinit var skip: TextView

    private val preferenceRepository: PreferenceRepository by inject()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!preferenceRepository.firstLaunch) {
            startActivity(Intent(this, BookListActivity::class.java))
            finish()
        }

        login = findViewById(R.id.logInButton)
        register = findViewById(R.id.registerButton)
        skip = findViewById(R.id.withoutLog)

        login.setOnClickListener {
            startActivity(Intent(this, LogInActivity::class.java))
        }

        register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        skip.setOnClickListener {
            startActivity(Intent(this, BookListActivity::class.java))
            preferenceRepository.firstLaunch = false
            finish()
        }
    }
}


