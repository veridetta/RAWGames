package com.inc.vr.corp.apps.rawgames.ui.fragments.cari



import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.inc.vr.corp.apps.rawgames.domain.dataSource.CariDataSourceFactory
import com.inc.vr.corp.apps.rawgames.network.dto.Models
import com.inc.vr.corp.apps.rawgames.ui.base.BaseViewModel
import javax.inject.Inject

private const val PAGE_SIZE = 10
private const val INITIAL_LOAD_SIZE_HINT = 20

class CariViewModel @Inject constructor(
    private val dataSourceFactory: CariDataSourceFactory
) : BaseViewModel<PagedList<Models.CariResult>>() {

    var cachedFilter: String = ""

    fun setFilter(filter: String) {
        dataSourceFactory.setFilter(if (cachedFilter.isEmpty()) filter else cachedFilter)
    }

    init {
        createLiveData()
    }

    fun createLiveData() {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
            .setPageSize(PAGE_SIZE)
            .build()
        this.stateLiveData = LivePagedListBuilder(dataSourceFactory, pagedListConfig).build();
    }

}