package com.example.bookcrossingapplication.ui.booklist

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookcrossingapplication.R
import com.example.bookcrossingapplication.ui.book.BookActivity
import com.example.bookcrossingapplication.ui.user.UserActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookListActivity : AppCompatActivity() {
    private val vm: BookListViewModel by viewModel()

    private lateinit var bottomBar: BottomNavigationView
    private lateinit var recycler: RecyclerView
    private lateinit var searchEditText: EditText

    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        setupBindings()
        setupUi()
        setupSubscriptions()
    }

    private fun setupBindings() {
        recycler = findViewById(R.id.recycler)
        bottomBar = findViewById(R.id.bottomNavigationView)
        searchEditText = findViewById(R.id.searchEditText)
    }

    private fun setupUi() {
        bottomBar.selectedItemId = R.id.menu_list
        bottomBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_profile -> {
                    startActivity(Intent(this, UserActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }

        searchEditText.addTextChangedListener {
            it?.let {
                vm.search(it.toString())
            }
        }

        setupRecycler()
    }

    private fun setupSubscriptions() {
        vm.books.observe(this) { list ->
            adapter.updateList(list)
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
        (recycler.layoutManager as GridLayoutManager).spanCount = 2
    }
}