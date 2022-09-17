package com.srj.w16t_marvel.model.response.marvelResponse

import com.google.gson.annotations.SerializedName

data class Url(
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String?
)