package com.gorodechnyj.moviedb.network.state

import kotlinx.coroutines.flow.Flow

interface NetworkState {

    val connectedFlow: Flow<Boolean>

    fun isConnected(): Boolean
}
