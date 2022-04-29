package com.inc.vr.corp.apps.rawgames.network.dto

import com.google.gson.annotations.SerializedName

sealed class Models {
    //serialized integer count, string next, String previous, List<GameResults> results, Boolean user_platform
    data class BaseGame(@SerializedName("count") val count: Int,
                        @SerializedName("next") val next: String,
                        @SerializedName("previous") val previous: String,
                        @SerializedName("results") val results: List<GameResults>,
                        @SerializedName("user_platform") val userPlatform: Boolean)

    //serialized integer id, string name, string background_image, string released, string rating
    data class GameResults(@SerializedName("id") val id: Int,
                           @SerializedName("name") val name: String,
                           @SerializedName("background_image") val backgroundImage: String,
                           @SerializedName("released") val released: String,
                           @SerializedName("rating") val rating: String)
    data class BaseRating(@SerializedName("count") val count: Int,
                          @SerializedName("next") val next: String,
                          @SerializedName("previous") val previous: String,
                          @SerializedName("results") val results: List<RatingResult>,
                          @SerializedName("user_platform") val userPlatform: Boolean)

    //serialized integer id, string name, string background_image, string released, string rating
    data class RatingResult(@SerializedName("id") val id: Int,
                           @SerializedName("name") val name: String,
                           @SerializedName("background_image") val backgroundImage: String,
                           @SerializedName("released") val released: String,
                           @SerializedName("rating") val rating: String)

    data class BaseCari(@SerializedName("count") val count: Int,
                          @SerializedName("next") val next: String,
                          @SerializedName("previous") val previous: String,
                          @SerializedName("results") val results: List<CariResult>,
                          @SerializedName("user_platform") val userPlatform: Boolean)

    //serialized integer id, string name, string background_image, string released, string rating
    data class CariResult(@SerializedName("id") val id: Int,
                            @SerializedName("name") val name: String,
                            @SerializedName("background_image") val backgroundImage: String,
                            @SerializedName("released") val released: String,
                            @SerializedName("rating") val rating: String)
}