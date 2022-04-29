package com.inc.vr.corp.apps.rawgames.domain.repository

interface ConnectivityManagerLocal {
    fun hasNetwork(): Boolean?
}