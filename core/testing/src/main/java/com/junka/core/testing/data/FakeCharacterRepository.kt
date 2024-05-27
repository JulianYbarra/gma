package com.junka.core.testing.data

import com.junka.core.domain.DataError
import com.junka.core.domain.Result
import com.junka.core.domain.character.Character
import com.junka.core.domain.character.CharacterRemoteDataSource
import com.junka.core.domain.character.CharacterRepository

class FakeCharacterRepository(
    private val remoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {
    override suspend fun fetchCharacters(): Result<List<Character>, DataError.Network> {
        return remoteDataSource.getCharacters()
    }
}