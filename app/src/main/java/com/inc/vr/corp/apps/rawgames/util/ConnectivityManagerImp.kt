package com.inc.vr.corp.apps.rawgames.util

import android.content.Context
import android.net.ConnectivityManager

import android.net.NetworkInfo
import com.inc.vr.corp.apps.rawgames.di.scope.ForApplication
import com.inc.vr.corp.apps.rawgames.domain.repository.ConnectivityManagerLocal
import javax.inject.Inject

class ConnectivityManagerImp @Inject constructor(@ForApplication val context: Context) :
    ConnectivityManagerLocal {
    override fun hasNetwork(): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}