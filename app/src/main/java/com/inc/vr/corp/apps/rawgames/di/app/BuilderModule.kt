package com.inc.vr.corp.apps.rawgames.di.app

import com.inc.vr.corp.apps.rawgames.ui.MainActivity
import com.inc.vr.corp.apps.rawgames.ui.SplashScreenActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module()
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    //splashscreen
    @ContributesAndroidInjector()
    abstract fun bindSplashScreenActivity(): SplashScreenActivity

}