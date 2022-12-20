package ${projectPackage}.${featurePackage}.ui

import androidx.lifecycle.viewModelScope
import com.gorodechnyj.core.mvi.InteractorViewModel
import com.gorodechnyj.core.mvi.interactors
import com.gorodechnyj.core.mvi.mapStateFlow
import ${projectPackage}.${featurePackage}.CatalogAction
import ${projectPackage}.${featurePackage}.CatalogInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ${featureNameCamelCase}ViewModel @Inject constructor(
    interactorFactory: ${featureNameCamelCase}Interactor.Factory,
    viewStateMapper: ${featureNameCamelCase}ViewStateMapper
) : InteractorViewModel() {

    private val interactor: ${featureNameCamelCase}Interactor by interactors {
        interactorFactory.create()
    }

    val viewStateFlow = interactor.stateFlow
    		.mapStateFlow(viewModelScope, viewStateMapper)

    fun loadMore() {
        if (viewStateFlow.value.canLoadMore) {
            interactor.action(${featureNameCamelCase}Action.LoadNextPage)
        }
    }
}
