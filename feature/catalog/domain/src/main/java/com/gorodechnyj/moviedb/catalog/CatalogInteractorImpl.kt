package com.gorodechnyj.moviedb.catalog

import com.gorodechnyj.core.ModelCoroutineScope
import com.gorodechnyj.core.coroutine.AppDispatchers
import com.gorodechnyj.core.log.Logger
import com.gorodechnyj.core.mvi.Middleware
import com.gorodechnyj.core.mvi.StoreData
import com.gorodechnyj.core.mvi.makeStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
class CatalogInteractorImpl private constructor(
    middlewares: Set<Middleware<CatalogEffect, CatalogState, CatalogSideEffect>>,
    dispatchers: AppDispatchers,
    logger: Logger
) : CatalogInteractor, CoroutineScope by ModelCoroutineScope(dispatchers) {

    private val store = makeStore(
        StoreData(
            middleware = middlewares,
            initState = CatalogState(),
            initEffects = listOf(
                CatalogEffect.LoadNextPage
            ),
            logger = logger,
            reducer = CatalogReducer(),
            dispatchers = dispatchers,
            actionToEffect = ::actionToEffect
        )
    )

    override val stateFlow: StateFlow<CatalogState>
        get() = store.stateFlow

    override val sideEffectFlow: SharedFlow<CatalogSideEffect>
        get() = store.sideEffectFlow

    override fun emitSideEffect(effect: CatalogSideEffect) {
        store.emitSideEffect(effect)
    }

    override fun action(value: CatalogAction) {
        store.action(value)
    }

    class Factory(
        val middlewares: Set<Middleware<CatalogEffect, CatalogState, CatalogSideEffect>>,
        val dispatchers: AppDispatchers,
        val logger: Logger
    ) : CatalogInteractor.Factory {

        override fun create(): CatalogInteractor {
            return CatalogInteractorImpl(
                middlewares,
                dispatchers,
                logger
            )
        }
    }
}

fun actionToEffect(action: CatalogAction): CatalogEffect = when (action) {
    CatalogAction.Init -> CatalogEffect.Init
    CatalogAction.LoadNextPage -> CatalogEffect.LoadNextPage
}
