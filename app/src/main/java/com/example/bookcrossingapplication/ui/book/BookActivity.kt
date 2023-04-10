package com.example.bookcrossingapplication.ui.book

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.bookcrossingapplication.R
import com.example.bookcrossingapplication.ui.user.UserActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookActivity : AppCompatActivity() {
    private val vm: BookViewModel by viewModel()

    private lateinit var image: ImageView
    private lateinit var title: TextView
    private lateinit var author: TextView
    private lateinit var genre: TextView
    private lateinit var userName: TextView
    private lateinit var description: TextView
    private lateinit var telegram: ImageButton
    private lateinit var whatsapp: ImageButton

    private val id: Int by lazy {
        intent.getIntExtra("bookId", -1)
            .also { if (it == -1) error("id can't be less than 1") }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivty_book)

        setupBindings()
        setupUi()
        setupSubscriptions()
        vm.requestBook(id)
    }

    private fun setupUi() {
        whatsapp.setOnClickListener {
            Toast.makeText(this, "whatsapp", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupSubscriptions() {
        vm.book.observe(this) { data ->
            with(data) {
                Glide.with(image)
                    .load(book.imageUrl)
                    .into(image)

                title.text = book.title
                author.text = book.author
                description.text = book.description
                userName.text = user.name

                telegram.isVisible = !user.telegramLink.isNullOrBlank()
                telegram.setOnClickListener {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(user.telegramLink)))
                }

                whatsapp.isVisible = !user.whatsappLink.isNullOrBlank()

                userName.setOnClickListener {
                    startActivity(Intent(this@BookActivity, UserActivity::class.java).putExtra("userId", user.id))
                }
            }
        }
    }

    private fun setupBindings() {
        image = findViewById(R.id.image)
        title = findViewById(R.id.bookName)
        author = findViewById(R.id.name)
        genre = findViewById(R.id.genre)
        userName = findViewById(R.id.bookcrosser_name)
        description = findViewById(R.id.description2)
        telegram = findViewById(R.id.telegram)
        whatsapp = findViewById(R.id.whatsapp)
    }
}