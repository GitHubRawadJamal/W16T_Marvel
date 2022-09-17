package com.srj.w16t_marvel.model.response.marvelResponse

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("path") val path: String?,
    @SerializedName("extension") val extension: String?,
)