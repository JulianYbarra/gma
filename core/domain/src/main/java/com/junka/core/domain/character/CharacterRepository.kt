package com.junka.core.domain.character

import com.junka.core.domain.DataError
import com.junka.core.domain.EmptyResult
import com.junka.core.domain.Result
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun fetchCharacters(): Result<List<Character>, DataError.Network>
}