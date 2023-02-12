package me.mattak.dicomparation.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class TextCellAdapter() :
    ListAdapter<TextCell, TextViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TextCell>() {
            override fun areItemsTheSame(oldItem: TextCell, newItem: TextCell): Boolean =
                oldItem.text == newItem.text

            override fun areContentsTheSame(oldItem: TextCell, newItem: TextCell): Boolean =
                oldItem.text == newItem.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}