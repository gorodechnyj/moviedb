package com.gorodechnyj.moviedb.catalog

sealed class CatalogAction {
    object Init : CatalogAction()
    object LoadNextPage : CatalogAction()
}
