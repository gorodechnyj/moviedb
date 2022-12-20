package com.gorodechnyj.moviedb.catalog.ui.adapter.viewholder

import com.bumptech.glide.Glide
import com.gorodechnyj.moviedb.catalog.databinding.ItemMovieBinding
import com.gorodechnyj.moviedb.catalog.ui.adapter.CatalogItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun movieViewHolderDelegate() = adapterDelegateViewBinding<CatalogItem.Movie, CatalogItem, ItemMovieBinding>(
    viewBinding = { inflater, parent ->
        ItemMovieBinding.inflate(inflater, parent, false)
    }
) {
    bind {
        binding.title.text = item.movie.nameRu
        val kinopoiskRating = item.movie.ratingKinopoisk ?: 0f
        val imdbRating = item.movie.ratingImdb ?: 0f
        binding.kinopoiskRatingBar.rating = kinopoiskRating
        binding.ratingKinopoiskValue.text = String.format("%.2f", kinopoiskRating)
        binding.ratingImdbValue.text = String.format("%.2f", imdbRating)

        Glide.with(binding.preview)
            .load(item.movie.posterUrlPreview)
            .into(binding.preview)
    }
}
