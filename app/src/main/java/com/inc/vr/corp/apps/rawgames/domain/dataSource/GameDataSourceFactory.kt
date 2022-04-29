package com.inc.vr.corp.apps.rawgames.domain.dataSource

import androidx.paging.DataSource
import com.inc.vr.corp.apps.rawgames.network.dto.Models
import javax.inject.Inject

class GameDataSourceFactory @Inject constructor(
    private val dataSource: GamePositionalDataSource
) : DataSource.Factory<Int, Models.GameResults>() {

    //val photosDataSourceLiveData = MutableLiveData<PhotoPositionalDataSource>()
    fun setFilter(filter: String) {
        dataSource.setFilter(filter)
    }

    override fun create(): DataSource<Int, Models.GameResults> {
       // photosDataSourceLiveData.postValue(dataSource)
            return dataSource
    }

}