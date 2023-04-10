package com.example.bookcrossingapplication.ui.account

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bookcrossingapplication.R
import com.example.bookcrossingapplication.ui.user.UserActivity

class LogInActivity : AppCompatActivity() {

    private lateinit var btnToRegister: TextView
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnToRegister = findViewById(R.id.regText)
        btnLogin = findViewById(R.id.logInButton2)

        btnToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnLogin.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }
}
