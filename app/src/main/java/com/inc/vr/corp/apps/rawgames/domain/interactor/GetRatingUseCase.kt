package com.inc.vr.corp.apps.rawgames.domain.interactor

import com.inc.vr.corp.apps.rawgames.domain.entity.RatingModel
import com.inc.vr.corp.apps.rawgames.domain.executer.PostExecutionThread
import com.inc.vr.corp.apps.rawgames.domain.executer.UseCaseExecutor
import com.inc.vr.corp.apps.rawgames.domain.interactor.base.SingleUseCase
import com.inc.vr.corp.apps.rawgames.domain.repository.Repository
import com.inc.vr.corp.apps.rawgames.network.dto.Models

import io.reactivex.Single
import javax.inject.Inject

class GetRatingUseCase @Inject
constructor(
    useCaseExecutor: UseCaseExecutor,
    postExecutionThread: PostExecutionThread,
    repository: Repository
) : SingleUseCase<Models.BaseRating, RatingModel>(useCaseExecutor, postExecutionThread, repository) {
    override fun interact(params: RatingModel): Single<Models.BaseRating> {
        //return multiple models
        return repository.getRatingUseCase(params)
    }
}