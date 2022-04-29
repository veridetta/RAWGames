package com.inc.vr.corp.apps.rawgames.data.repository

import android.annotation.SuppressLint
import com.inc.vr.corp.apps.rawgames.domain.entity.CariModel
import com.inc.vr.corp.apps.rawgames.domain.entity.GameModel
import com.inc.vr.corp.apps.rawgames.domain.entity.RatingModel
import com.inc.vr.corp.apps.rawgames.domain.repository.Repository
import com.inc.vr.corp.apps.rawgames.network.RestApi
import com.inc.vr.corp.apps.rawgames.network.dto.Models
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val restApi: RestApi) : Repository {
    @SuppressLint("CheckResult")
    override fun getGameUseCase(param: GameModel): Single<Models.BaseGame> {
        return Single.create { emitter ->
            restApi.getLatest(param.key, param.page_size,param.ordering,param.platforms,param.page).subscribe({ response ->
                Timber.d("response : %s", response)
                emitter.onSuccess(response)
            }, {
                emitter.onError(it)
            })
        }
    }

    @SuppressLint("CheckResult")
    override fun getRatingUseCase(param: RatingModel): Single<Models.BaseRating> {
        return Single.create { emitter ->
            restApi.getRating(  param.key, param.page_size,param.ordering,param.platforms,param.page).subscribe({ response ->
                Timber.d("response : %s", response)
                emitter.onSuccess(response)
            }, {
                emitter.onError(it)
            })
        }
    }

    @SuppressLint("CheckResult")
    override fun getCariUseCase(param: CariModel): Single<Models.BaseCari> {
        return Single.create { emitter ->
            restApi.getCari( param.key, param.page_size,param.platforms,param.page,param.search).subscribe({ response ->
                Timber.d("response : %s", response)
                emitter.onSuccess(response)
            }, {
                emitter.onError(it)
            })
        }
    }


}