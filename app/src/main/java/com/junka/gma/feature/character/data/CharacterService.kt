package com.junka.gma.feature.character.data

import com.junka.gma.feature.character.data.model.CharacterDto
import com.junka.gma.core.data.model.PaginationResponse
import retrofit2.http.GET

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(): PaginationResponse<CharacterDto>
}