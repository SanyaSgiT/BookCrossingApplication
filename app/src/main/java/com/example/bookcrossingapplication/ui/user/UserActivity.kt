package com.example.bookcrossingapplication.ui.user

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookcrossingapplication.MainActivity
import com.example.bookcrossingapplication.R
import com.example.bookcrossingapplication.ui.book.BookActivity
import com.example.bookcrossingapplication.ui.booklist.BookAdapter
import com.example.bookcrossingapplication.ui.booklist.BookListActivity
import com.example.bookcrossingapplication.ui.notifications.EditActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserActivity : AppCompatActivity() {
    private val vm: UserViewModel by viewModel()

    private lateinit var exit: TextView
    private lateinit var edit: ImageButton
    private lateinit var photo: ImageView
    private lateinit var name: TextView
    private lateinit var login: TextView
    private lateinit var bottomBar: BottomNavigationView
    private lateinit var recycler: RecyclerView

    private lateinit var adapter: BookAdapter

    private val userId: Int? by lazy {
        intent.getIntExtra("userId", -1).let {
            if (it == -1) null else it
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        setupBinding()
        setupUi()
        setupSubscriptions()

        vm.requestBooks(userId ?: 1)
    }

    private fun setupBinding() {
        exit = findViewById(R.id.exitText)
        edit = findViewById(R.id.edit)
        bottomBar = findViewById(R.id.bottomNavigationView)
        recycler = findViewById(R.id.recycler)
        photo = findViewById(R.id.user)
        name = findViewById(R.id.name)
        login = findViewById(R.id.phone)
    }

    private fun setupUi() {
        bottomBar.isVisible = isMyProfile()
        bottomBar.selectedItemId = R.id.menu_profile
        bottomBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_list -> {
                    startActivity(Intent(this, BookListActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }

        exit.isVisible = isMyProfile()
        exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        edit.isVisible = isMyProfile()
        edit.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }


        setupRecycler()
    }

    private fun setupSubscriptions() {
        vm.books.observe(this) { data ->
            with(data) {
                adapter.updateList(books)

                Glide.with(photo)
                    .load(user.photoUrl)
                    .circleCrop()
                    .into(photo)

                name.text = user.name
                login.text = "@${user.login}"
            }
        }
    }

    private fun setupRecycler() {
        adapter = BookAdapter {
            startActivity(
                Intent(
                    this,
                    BookActivity::class.java
                ).putExtra("bookId", it.id)
            )
        }

        recycler.adapter = adapter
        (recycler.layoutManager as GridLayoutManager).spanCount = 3
    }

    private fun isMyProfile() = userId == null
}