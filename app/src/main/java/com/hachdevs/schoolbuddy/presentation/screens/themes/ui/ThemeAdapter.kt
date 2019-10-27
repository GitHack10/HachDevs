package com.hachdevs.schoolbuddy.presentation.screens.themes.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hachdevs.schoolbuddy.R
import com.hachdevs.schoolbuddy.domain.global.models.ThemeItem
import com.hachdevs.schoolbuddy.presentation.global.util.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_theme.view.*

class ThemeAdapter(
    var list: List<ThemeItem>,
    private val itemClickListener: (ThemeItem) -> Unit
) : ListAdapter<ThemeItem, ThemeAdapter.ThemeHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeHolder {
        val itemView = parent.inflate(R.layout.item_theme)
        return ThemeHolder(itemView)
    }

    override fun onBindViewHolder(holder: ThemeHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ThemeHolder(override val containerView: View): ViewHolder(containerView), LayoutContainer {
        private val nameTextView = containerView.itemMenuTextTitle
        private val descTextView = containerView.itemMenuTextDesc

        fun bind(themeItem: ThemeItem) {
            nameTextView.text = themeItem.name
            descTextView.text = themeItem.desc

            descTextView.setTextColor(
                if (themeItem.allDecided) containerView.resources.getColor(R.color.colorBlue)
                else containerView.resources.getColor(R.color.textDesc)
            )

            itemView.setOnClickListener { itemClickListener(themeItem) }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ThemeItem>() {
        override fun areItemsTheSame(oldItem: ThemeItem, newItem: ThemeItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ThemeItem, newItem: ThemeItem): Boolean {
            return oldItem.equals(newItem)
        }
    }
}