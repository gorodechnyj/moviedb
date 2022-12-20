package com.gorodechnyj.moviedb.catalog.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.gorodechnyj.moviedb.data.model.SearchItem

sealed class CatalogItem {

    data class Movie(
        val movie: SearchItem
    ) : CatalogItem()

    companion object {
        val DIFF_ITEM_CALLBACK = object : DiffUtil.ItemCallback<CatalogItem>() {

            override fun areItemsTheSame(oldItem: CatalogItem, newItem: CatalogItem) =
                oldItem::class == newItem::class

            override fun areContentsTheSame(oldItem: CatalogItem, newItem: CatalogItem) =
                oldItem == newItem
        }
    }
}
