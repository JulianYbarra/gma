package com.junka.gma.feature.character.domain

import com.junka.gma.core.domain.DataError
import com.junka.gma.core.domain.Result

interface CharacterRemoteDataSource {
    suspend fun getCharacters(): Result<List<Character>, DataError.Network>
}