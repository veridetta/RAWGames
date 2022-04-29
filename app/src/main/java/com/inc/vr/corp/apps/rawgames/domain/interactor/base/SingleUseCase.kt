package com.inc.vr.corp.apps.rawgames.domain.interactor.base

import com.inc.vr.corp.apps.rawgames.domain.executer.PostExecutionThread
import com.inc.vr.corp.apps.rawgames.domain.executer.UseCaseExecutor
import com.inc.vr.corp.apps.rawgames.domain.repository.Repository
import io.reactivex.Single

/**
 * @param Responses The response value emitted by the Observable.
 * @param Params The request value.
 */
abstract class SingleUseCase<Responses, Params>(useCaseExecutor: UseCaseExecutor,
                                                postExecutionThread: PostExecutionThread,
                                                protected var repository: Repository
) :
    UseCase<Single<Responses>, Params>(useCaseExecutor, postExecutionThread) {

    open fun execute(params: Params): Single<Responses> {
        return interact(params).applySchedulers()

    }

    protected abstract fun interact(params: Params): Single<Responses>

}