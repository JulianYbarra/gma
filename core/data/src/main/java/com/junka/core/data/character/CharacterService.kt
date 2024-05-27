package com.junka.core.data.character

import com.junka.core.data.model.PaginationResponse
import com.junka.core.data.model.CharacterDto
import retrofit2.http.GET

interface CharacterService {

    @GET("api/character")
    suspend fun getCharacters(): PaginationResponse<CharacterDto>
}