package com.junka.core.domain.character

import com.junka.core.domain.DataError
import com.junka.core.domain.Result

interface CharacterRemoteDataSource {
    suspend fun getCharacters(): Result<List<Character>,DataError.Network>
}