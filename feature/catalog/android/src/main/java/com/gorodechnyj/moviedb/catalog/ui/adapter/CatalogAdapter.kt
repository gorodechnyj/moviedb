package com.gorodechnyj.moviedb.catalog.ui.adapter

import com.gorodechnyj.moviedb.catalog.ui.adapter.viewholder.movieViewHolderDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class CatalogAdapter : AsyncListDifferDelegationAdapter<CatalogItem>(
    CatalogItem.DIFF_ITEM_CALLBACK,
    movieViewHolderDelegate()
)

