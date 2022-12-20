package com.gorodechnyj.network.state

import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.net.NetworkRequest
import android.os.Build
import com.gorodechnyj.moviedb.network.state.NetworkState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

@ExperimentalCoroutinesApi
class NetworkStateImpl(
    private val connectivityManager: ConnectivityManager
) : NetworkState {

    private val networkRequest = NetworkRequest.Builder()
        .addCapability(NET_CAPABILITY_INTERNET)
        .build()

    override val connectedFlow: Flow<Boolean>
        @SuppressLint("MissingPermission")
        get() = callbackFlow {
            val networkCallback = object : NetworkCallback() {
                override fun onCapabilitiesChanged(
                    network: Network,
                    capabilities: NetworkCapabilities
                ) {
                    trySend(isConnected())
                }

                override fun onLost(network: Network) {
                    trySend(isConnected())
                }
            }
            connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
            awaitClose { connectivityManager.unregisterNetworkCallback(networkCallback) }
        }

    @SuppressLint("MissingPermission")
    override fun isConnected(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork
            val netInfo = connectivityManager.getNetworkCapabilities(activeNetwork)
            netInfo?.hasCapability(NET_CAPABILITY_INTERNET)
        } else {
            val netInfo = connectivityManager.activeNetworkInfo
            netInfo?.isConnectedOrConnecting
        } ?: false
    }
}
