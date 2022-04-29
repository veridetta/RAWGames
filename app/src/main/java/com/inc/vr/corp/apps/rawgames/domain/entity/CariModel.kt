package com.inc.vr.corp.apps.rawgames.domain.entity

import retrofit2.http.Query

data class CariModel(
    val key : String = "388b9722d54a4056b87d2ec47cafd0d7",
    val page_size: Int=10,
    val platforms: Int=4,
    val page : Int=1,
    val search : String=""
)