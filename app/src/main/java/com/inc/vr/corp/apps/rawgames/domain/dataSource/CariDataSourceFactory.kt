package com.inc.vr.corp.apps.rawgames.domain.dataSource

import androidx.paging.DataSource
import com.inc.vr.corp.apps.rawgames.network.dto.Models
import javax.inject.Inject

class CariDataSourceFactory @Inject constructor(
    private val dataSource: CariPositionalDataSource
) : DataSource.Factory<Int, Models.CariResult>() {

    //val photosDataSourceLiveData = MutableLiveData<PhotoPositionalDataSource>()
    fun setFilter(filter: String) {
        dataSource.setFilter(filter)
    }

    override fun create(): DataSource<Int, Models.CariResult> {
        // photosDataSourceLiveData.postValue(dataSource)
        return dataSource
    }

}