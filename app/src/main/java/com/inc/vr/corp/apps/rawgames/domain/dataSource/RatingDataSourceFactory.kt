package com.inc.vr.corp.apps.rawgames.domain.dataSource

import androidx.paging.DataSource
import com.inc.vr.corp.apps.rawgames.network.dto.Models
import javax.inject.Inject

class RatingDataSourceFactory @Inject constructor(
    private val dataSource: RatingPositionalDataSource
) : DataSource.Factory<Int, Models.RatingResult>() {

    //val photosDataSourceLiveData = MutableLiveData<PhotoPositionalDataSource>()
    fun setFilter(filter: String) {
        dataSource.setFilter(filter)
    }

    override fun create(): DataSource<Int, Models.RatingResult> {
        // photosDataSourceLiveData.postValue(dataSource)
        return dataSource
    }

}