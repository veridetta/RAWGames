package com.inc.vr.corp.apps.rawgames.domain.repository

import com.inc.vr.corp.apps.rawgames.domain.entity.CariModel
import com.inc.vr.corp.apps.rawgames.domain.entity.GameModel
import com.inc.vr.corp.apps.rawgames.domain.entity.RatingModel
import com.inc.vr.corp.apps.rawgames.network.dto.Models

import io.reactivex.Single

interface Repository {
    fun getRatingUseCase(param: RatingModel): Single<Models.BaseRating>
    fun getGameUseCase(param: GameModel): Single<Models.BaseGame>
    fun getCariUseCase(param: CariModel): Single<Models.BaseCari>
}