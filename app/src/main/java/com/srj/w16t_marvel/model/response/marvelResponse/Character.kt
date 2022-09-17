package com.srj.w16t_marvel.model.response.marvelResponse

import com.google.gson.annotations.SerializedName
import java.util.*

data class Character(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("modified") val modified: Date?,
    @SerializedName("resourceURI") val resourceURI: String?,
    @SerializedName("urls") val urls: List<Url>?,
    @SerializedName("thumbnail") val thumbnail: Image?,
    @SerializedName("comics") val comics: SubList?,
    @SerializedName("stories") val stories: StoryList?,
    @SerializedName("events") val events: SubList?,
    @SerializedName("series") val series: SubList?,
 )