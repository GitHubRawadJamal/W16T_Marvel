package com.srj.w16t_marvel.model.response.marvelResponse

import com.google.gson.annotations.SerializedName

data class SubItemSummary(
    @SerializedName("resourceURI") val resourceURI: String?,
    @SerializedName("name") val name: String?,
)