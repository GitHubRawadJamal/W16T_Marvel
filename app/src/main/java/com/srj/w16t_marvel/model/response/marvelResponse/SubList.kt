package com.srj.w16t_marvel.model.response.marvelResponse

import com.google.gson.annotations.SerializedName

data class SubList(
    @SerializedName("available") val available: Int?,
    @SerializedName("returned") val returned: Int?,
    @SerializedName("collectionURI") val collectionURI: String?,
    @SerializedName("items") val items: List<SubItemSummary>?,
)