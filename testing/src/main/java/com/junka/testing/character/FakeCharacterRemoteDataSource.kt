package com.junka.testing.character

import com.junka.gma.core.domain.DataError
import com.junka.gma.core.domain.Result
import com.junka.gma.feature.character.domain.Character
import com.junka.gma.feature.character.domain.CharacterRemoteDataSource

class FakeCharacterRemoteDataSource(
    private val characters: List<Character> = emptyList()
) : CharacterRemoteDataSource {
    override suspend fun getCharacters(): Result<List<Character>, DataError.Network> {
        return Result.Success(characters)
    }
}