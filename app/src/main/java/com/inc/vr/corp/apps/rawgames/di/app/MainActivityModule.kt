package com.inc.vr.corp.apps.rawgames.di.app

import com.inc.vr.corp.apps.rawgames.ui.fragments.cari.CariFragment
import com.inc.vr.corp.apps.rawgames.ui.fragments.gameDetail.GameDetailFragment
import com.inc.vr.corp.apps.rawgames.ui.fragments.splash.SplashFragment
import com.inc.vr.corp.apps.rawgames.ui.fragments.games.GamesFragment
import com.inc.vr.corp.apps.rawgames.ui.fragments.rating.RatingFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeGamesFragment(): GamesFragment

    @ContributesAndroidInjector
    //Rating
    abstract fun contributeRatingFragment(): RatingFragment

    @ContributesAndroidInjector
    abstract fun contributeCariFragment(): CariFragment

    @ContributesAndroidInjector
    abstract fun contributeGameDetailFragment(): GameDetailFragment

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

}