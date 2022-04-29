package com.inc.vr.corp.apps.rawgames.network

import com.inc.vr.corp.apps.rawgames.network.dto.Models

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    companion object {
        const val BASE_URL = "https://api.rawg.io/api/"
        const val API_KEY = "388b9722d54a4056b87d2ec47cafd0d7"
    }
//https://api.rawg.io/api/games?key=388b9722d54a4056b87d2ec47cafd0d7&page_size=10&platforms=4&search=sims&page=1
    //https://api.rawg.io/api/games?key=388b9722d54a4056b87d2ec47cafd0d7&page_size=10&ordering=rating&platforms=4&page=1
    //https://api.rawg.io/api/games?key=80e5801863dd41a1b6f9f6d7b033f03d&page_size=10&ordering=released&platforms=4&page=1&dates=2021-12-01,2021-12-31

    @GET("games?")
    fun getRating(@Query("key") key:String? = API_KEY,
                  @Query("page_size") pageSize:Int? = 10,
                  @Query("ordering") ordering:String? = "rating",
                  @Query("platforms") platforms:Int? = 4,
                  @Query("page") pageNum :Int?,
                  @Query("dates") dates:String? = "2021-12-01,2021-12-31"): Single<Models.BaseRating>
    @GET("games?")
    fun getLatest(
        @Query("key") key:String? = API_KEY,
        @Query("page_size") pageSize:Int? = 10,
        @Query("ordering") ordering:String? = "released",
        @Query("platforms") platforms:Int? = 4,
        @Query("page") pageNum :Int?,
        @Query("dates") dates:String? = "2021-12-01,2021-12-31"): Single<Models.BaseGame>

    @GET("games?")
    fun getCari(
        @Query("key") key:String? = API_KEY,
        @Query("page_size") pageSize:Int? = 10,
        @Query("platforms") platforms:Int? = 4,
        @Query("page") pageNum :Int?,
        @Query("search") search:String?=""): Single<Models.BaseCari>
}