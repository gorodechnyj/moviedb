package com.gorodechnyj.moviedb.catalog.ui

import androidx.lifecycle.viewModelScope
import com.gorodechnyj.core.mvi.InteractorViewModel
import com.gorodechnyj.core.mvi.interactors
import com.gorodechnyj.core.mvi.mapStateFlow
import com.gorodechnyj.moviedb.catalog.CatalogAction
import com.gorodechnyj.moviedb.catalog.CatalogInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    interactorFactory: CatalogInteractor.Factory,
    viewStateMapper: CatalogViewStateMapper
) : InteractorViewModel() {

    private val interactor: CatalogInteractor by interactors {
        interactorFactory.create()
    }

    val catalogFlow = interactor.stateFlow.mapStateFlow(viewModelScope, viewStateMapper)

    fun loadMore() {
        if (catalogFlow.value.canLoadMore) {
            interactor.action(CatalogAction.LoadNextPage)
        }
    }
}
