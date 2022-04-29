package com.inc.vr.corp.apps.rawgames.di.app

import android.content.Context
import com.inc.vr.corp.apps.rawgames.App
import com.inc.vr.corp.apps.rawgames.data.extractor.NetworkJobExecutor
import com.inc.vr.corp.apps.rawgames.di.scope.ForApplication
import com.inc.vr.corp.apps.rawgames.domain.executer.PostExecutionThread
import com.inc.vr.corp.apps.rawgames.domain.executer.UseCaseExecutor
import com.inc.vr.corp.apps.rawgames.domain.repository.ConnectivityManagerLocal
import com.inc.vr.corp.apps.rawgames.ui.executer.UiThreadExecutor
import com.inc.vr.corp.apps.rawgames.util.ConnectivityManagerImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideUseCaseExecutor(): UseCaseExecutor {
        return NetworkJobExecutor()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun postExecutionThread(): PostExecutionThread = UiThreadExecutor()


    @Provides
    @JvmStatic
    @ForApplication
    fun provideContext(app: App): Context = app.applicationContext

    @Provides
    @JvmStatic
    @Singleton
    fun provideConnectivityManager(connectivityManagerImp: ConnectivityManagerImp)
            : ConnectivityManagerLocal = connectivityManagerImp
}
