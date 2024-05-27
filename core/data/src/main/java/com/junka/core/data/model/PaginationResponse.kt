package com.junka.core.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PaginationResponse<T>(
    @Json(name = "results")
    val results : List<T>
)