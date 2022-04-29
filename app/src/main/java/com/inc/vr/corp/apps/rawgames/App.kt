package com.inc.vr.corp.apps.rawgames

import androidx.databinding.ktx.BuildConfig
import com.inc.vr.corp.apps.rawgames.di.app.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

import timber.log.Timber


class App : DaggerApplication() {


    override fun onCreate() {
        super.onCreate()
        timber()
    }

    private fun timber() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}