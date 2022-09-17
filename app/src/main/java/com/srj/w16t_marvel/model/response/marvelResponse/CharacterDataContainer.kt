package com.srj.w16t_marvel.model.response.marvelResponse

import com.google.gson.annotations.SerializedName

data class CharacterDataContainer(
    @SerializedName("count") val count: Int?,
    @SerializedName("limit") val limit: Int?,
    @SerializedName("offset") val offset: Int?,
    @SerializedName("results") val results: List<Character>?,
    @SerializedName("total") val total: Int?
 )
