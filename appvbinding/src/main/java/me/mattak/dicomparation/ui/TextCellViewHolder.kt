package me.mattak.dicomparation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.mattak.dicomparation.databinding.CellTextBinding

class TextViewHolder(private val binding: CellTextBinding) : RecyclerView.ViewHolder(
    binding.root
) {
    companion object {
        fun create(viewGroup: ViewGroup) = TextViewHolder(
            CellTextBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false,
            )
        )
    }

    fun bind(cell: TextCell) {
        binding.text.text = cell.text
    }
}
