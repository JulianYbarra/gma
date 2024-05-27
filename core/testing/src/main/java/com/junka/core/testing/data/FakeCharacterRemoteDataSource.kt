package com.junka.core.testing.data

import com.junka.core.domain.DataError
import com.junka.core.domain.Result
import com.junka.core.domain.character.Character
import com.junka.core.domain.character.CharacterRemoteDataSource

class FakeCharacterRemoteDataSource(
    private val characters: List<Character> = emptyList()
) : CharacterRemoteDataSource {
    override suspend fun getCharacters(): Result<List<Character>, DataError.Network> {
        return Result.Success(characters)
    }
}