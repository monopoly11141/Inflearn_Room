package com.example.inflearn_room.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.inflearn_room.R
import com.example.inflearn_room.entity.TextEntity

class TextAdapter(private val textList: List<TextEntity>) : RecyclerView.Adapter<TextAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_item, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: TextAdapter.ViewHolder, position: Int) {

        holder.bind(textList[position])

    }

    override fun getItemCount(): Int {

        return textList.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(textEntity: TextEntity) {

            val tvText = itemView.findViewById<TextView>(R.id.tvText)

            tvText.text = textEntity.text

        }
    }

}