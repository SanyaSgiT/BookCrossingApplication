package com.example.bookcrossingapplication.ui.booklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookcrossingapplication.R
import com.example.bookcrossingapplication.domain.Book

class BookAdapter(
    private val onBookClicked: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var items: List<Book> = emptyList()

    fun updateList(newItems: List<Book>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            LayoutInflater
                .from(parent.context).inflate(R.layout.item_book, parent, false),
            onBookClicked
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class BookViewHolder(itemView: View, private val onBookClicked: (Book) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: Book) {
            itemView.setOnClickListener {
                onBookClicked(book)
            }

            itemView.findViewById<TextView>(R.id.bookName).text = book.title
            itemView.findViewById<TextView>(R.id.author).text = book.author

            val imageView = itemView.findViewById<ImageView>(R.id.image)

            Glide
                .with(imageView)
                .load(book.imageUrl)
                .into(imageView)
        }
    }

}