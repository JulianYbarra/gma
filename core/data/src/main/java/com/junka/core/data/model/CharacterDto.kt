package com.junka.core.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterDto(
    @Json(name = "id")
    val id : Int,
    @Json(name = "name")
    val name : String,
    @Json(name = "status")
    val status : String,
    @Json(name = "species")
    val species : String,
    @Json(name = "type")
    val type : String,
    @Json(name = "origin")
    val origin : LocationDto,
    @Json(name = "location")
    val location : LocationDto,
    @Json(name = "image")
    val image : String,
    @Json(name = "episode")
    val episodes : List<String>,
)