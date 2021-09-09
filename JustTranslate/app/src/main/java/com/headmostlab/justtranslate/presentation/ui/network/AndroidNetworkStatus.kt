package com.headmostlab.justtranslate.presentation.ui.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import com.headmostlab.justtranslate.data.repositories.interfaces.network.NetworkStatus

class AndroidNetworkStatus(context: Context) : NetworkStatus {

    private var status: Boolean = false

    init {

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val request = NetworkRequest.Builder().build()

        connectivityManager.registerNetworkCallback(
            request,
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    status = true
                }

                override fun onUnavailable() {
                    status = false
                }

                override fun onLost(network: Network) {
                    status = false
                }
            })
    }

    override fun isOnline(): Boolean = status
}