package com.example.bookcrossingapplication.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.bookcrossingapplication.R
import com.example.bookcrossingapplication.ui.user.UserActivity

class EditActivity : AppCompatActivity() {

    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_editing)

        btnSave = findViewById(R.id.registerButton2)

        btnSave.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }
}