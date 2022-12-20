package com.gorodechnyj.core.mvi

typealias Reducer<Effect, State> = (effect: Effect, state: State) -> State
