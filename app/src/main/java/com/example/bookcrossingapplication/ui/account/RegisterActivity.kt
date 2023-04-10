package com.example.bookcrossingapplication.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bookcrossingapplication.R
import com.example.bookcrossingapplication.ui.user.UserActivity

class RegisterActivity : AppCompatActivity(), OnClickListener {

    private lateinit var btnLogin: TextView
    private lateinit var btnReg: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnLogin = findViewById(R.id.logInText)
        btnReg = findViewById(R.id.registerButton2)

        btnReg.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.logInText -> {
                val intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
            }
            R.id.registerButton2 -> {
                val intent = Intent(this, UserActivity::class.java)
                startActivity(intent)
            }
            else -> {}
        }
    }
}
