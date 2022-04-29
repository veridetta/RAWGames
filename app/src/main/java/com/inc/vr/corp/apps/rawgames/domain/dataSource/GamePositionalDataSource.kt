package com.inc.vr.corp.apps.rawgames.domain.dataSource

import androidx.paging.PositionalDataSource
import com.inc.vr.corp.apps.rawgames.domain.entity.GameModel
import com.inc.vr.corp.apps.rawgames.domain.interactor.GetGameUseCase
import com.inc.vr.corp.apps.rawgames.network.dto.Models

import javax.inject.Inject

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber


class GamePositionalDataSource @Inject constructor(
    private val getGameUseCase: GetGameUseCase
) : PositionalDataSource<Models.GameResults>(), Disposable {

    private var disposing = false
    override fun isDisposed(): Boolean {
        return disposing
    }

    override fun dispose() {
        disposing = true
        compositeDisposable.clear()
    }

    private var filter: String = ""
    fun setFilter(filter: String) {
        this.filter = filter
    }

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private fun computeCount(): Int {
        // actual count code here
        return getGameUseCase.execute(GameModel()).blockingGet().count
    }


    private fun loadRangeInternal(startPosition: Int, loadCount: Int) {
        // actual load code here

        val pageNum = startPosition / loadCount + 1
        val disposable = getGameUseCase.execute(GameModel(filter, loadCount, "released",pageNum)).subscribe({ response ->
            // Timber.i("emitter size is"+response.size)
        }, { t: Throwable? ->
            Timber.e(t)
        })
        compositeDisposable.add(disposable)

    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Models.GameResults>) {

        val pageNum = params.startPosition / params.loadSize + 1
        val disposable = getGameUseCase.execute(GameModel(filter, params.loadSize, "released",pageNum)).subscribe({ response ->
            // Timber.i("emitter size is"+response.size)
            callback.onResult(response.results);
        }, { t: Throwable? ->
            Timber.e(t)
        })
        compositeDisposable.add(disposable)

    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Models.GameResults>) {
        val totalCount = 2000
        val position = computeInitialLoadPosition(params, totalCount)
        val loadSize = computeInitialLoadSize(params, position, totalCount)

        val pageNum = position / loadSize + 1
        val disposable = getGameUseCase.execute(GameModel(filter, loadSize, "released",pageNum)).subscribe({ response ->
            callback.onResult(response.results, position, response.count)
        }, { t: Throwable? ->
            Timber.e(t)
        })
        compositeDisposable.add(disposable)

    }
}