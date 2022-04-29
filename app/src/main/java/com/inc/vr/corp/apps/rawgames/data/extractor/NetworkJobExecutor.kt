package com.inc.vr.corp.apps.rawgames.data.extractor


import com.inc.vr.corp.apps.rawgames.domain.executer.UseCaseExecutor
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * provides background thread to prevent locking ui when calling network api
 */

class NetworkJobExecutor : UseCaseExecutor {
    override val scheduler: Scheduler
        get() = Schedulers.io()
}