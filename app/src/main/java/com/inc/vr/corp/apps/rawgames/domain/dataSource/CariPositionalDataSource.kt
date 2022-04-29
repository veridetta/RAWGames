package com.inc.vr.corp.apps.rawgames.domain.dataSource

import androidx.paging.PositionalDataSource
import com.inc.vr.corp.apps.rawgames.domain.entity.CariModel
import com.inc.vr.corp.apps.rawgames.domain.entity.GameModel
import com.inc.vr.corp.apps.rawgames.domain.entity.RatingModel
import com.inc.vr.corp.apps.rawgames.domain.interactor.GetCariUseCase
import com.inc.vr.corp.apps.rawgames.domain.interactor.GetRatingUseCase
import com.inc.vr.corp.apps.rawgames.network.dto.Models
import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber


class CariPositionalDataSource @Inject constructor(
    private val getCariUseCase: GetCariUseCase
) : PositionalDataSource<Models.CariResult>(), Disposable {

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
        return getCariUseCase.execute(CariModel())
            .blockingGet()
            .count
    }


    private fun loadRangeInternal(startPosition: Int, loadCount: Int) {
        // actual load code here

    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Models.CariResult>) {
        //load only max 10
        val pageNum = params.startPosition / params.loadSize + 1
        val disposable = getCariUseCase.execute(CariModel("", params.loadSize, 4,pageNum,filter)).subscribe({ response ->
            // Timber.i("emitter size is"+response.size)
            callback.onResult(response.results);
        }, { t: Throwable? ->
            Timber.e(t)
        })
        compositeDisposable.add(disposable)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Models.CariResult>) {
        val totalCount = 1000
        val position = computeInitialLoadPosition(params, totalCount)
        val loadSize = computeInitialLoadSize(params, position, totalCount)

        val pageNum = position / loadSize + 1
        val disposable = getCariUseCase.execute(CariModel("", loadSize, 4,pageNum,filter)).subscribe({ response ->
            callback.onResult(response.results, position, response.count)
        }, { t: Throwable? ->
            Timber.e(t)
        })
        compositeDisposable.add(disposable)


    }
}