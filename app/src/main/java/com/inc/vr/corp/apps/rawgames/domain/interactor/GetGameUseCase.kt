package com.inc.vr.corp.apps.rawgames.domain.interactor

import com.inc.vr.corp.apps.rawgames.domain.entity.GameModel
import com.inc.vr.corp.apps.rawgames.domain.executer.PostExecutionThread
import com.inc.vr.corp.apps.rawgames.domain.executer.UseCaseExecutor
import com.inc.vr.corp.apps.rawgames.domain.interactor.base.SingleUseCase
import com.inc.vr.corp.apps.rawgames.domain.repository.Repository
import com.inc.vr.corp.apps.rawgames.network.dto.Models

import io.reactivex.Single
import javax.inject.Inject

class GetGameUseCase @Inject
constructor(
    useCaseExecutor: UseCaseExecutor,
    postExecutionThread: PostExecutionThread,
    repository: Repository
) : SingleUseCase<Models.BaseGame, GameModel>(useCaseExecutor, postExecutionThread, repository) {
    override fun interact(params: GameModel): Single<Models.BaseGame> {
        //return multiple models
        return repository.getGameUseCase(params)
    }
}