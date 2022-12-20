package com.gorodechnyj.core

import com.gorodechnyj.core.coroutine.AppDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ModelCoroutineScope(dispatchers: AppDispatchers) : CoroutineScope {
    override val coroutineContext = SupervisorJob() + dispatchers.main
}
