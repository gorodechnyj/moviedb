package com.gorodechnyj.moviedb.catalog

import com.gorodechnyj.core.Model

interface CatalogInteractor : Model<CatalogState, CatalogAction, CatalogSideEffect> {

    interface Factory {

        fun create(): CatalogInteractor
    }
}
