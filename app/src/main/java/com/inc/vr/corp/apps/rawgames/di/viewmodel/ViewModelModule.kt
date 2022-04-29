package com.inc.vr.corp.apps.rawgames.di.viewmodel

import androidx.lifecycle.ViewModel
import com.inc.vr.corp.apps.rawgames.ui.fragments.gameDetail.GameDetailViewModel
import com.inc.vr.corp.apps.rawgames.ui.fragments.splash.SplashModel
import com.inc.vr.corp.apps.rawgames.ui.fragments.games.GamesViewModel
import com.inc.vr.corp.apps.rawgames.ui.fragments.rating.RatingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(clazz = GamesViewModel::class)
    abstract fun bindGamesViewModel(viewModel: GamesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(clazz = RatingViewModel::class)
    abstract fun bindRatingViewModel(viewModel: RatingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(clazz = GameDetailViewModel::class)
    abstract fun bindGameDetailViewModel(viewModel: GameDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(clazz = SplashModel::class)
    abstract fun bindSplashModel(viewModel: SplashModel): ViewModel

}