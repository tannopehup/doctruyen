package com.example.doctruyen.Adapter

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doctruyen.Model.BookData
import com.example.doctruyen.Model.BookDataTest
import com.example.doctruyen.R
import com.example.doctruyen.databinding.CategoryRowItemBinding

class MyBookAdapter(val context: Context, val bookData: List<BookDataTest>) : RecyclerView.Adapter<MyBookAdapter.ViewHolder>(){

    var onItemClick:((BookDataTest)->Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBookAdapter.ViewHolder {
        val binding =
            CategoryRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyBookAdapter.ViewHolder, position: Int) {
        holder.bookName.text = bookData[position].book
        holder.author.text = bookData[position].author
        val uri = Uri.parse(bookData[position].img.toString())
        holder.bind(uri)
    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class ViewHolder(binding:CategoryRowItemBinding): RecyclerView.ViewHolder(binding.root){
        val bookImg =binding.imgAuthorLib
        val bookName = binding.nameAuthorLib
        val author = binding.bestAuditorName
        fun bind(uri: Uri) {
            Glide.with(context).load(uri).into(bookImg)
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(bookData[adapterPosition])

            }
        }
    }

}