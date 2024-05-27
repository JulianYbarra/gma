package com.junka.core.data.character

import com.junka.core.domain.DataError
import com.junka.core.domain.Result
import com.junka.core.domain.character.Character
import com.junka.core.domain.character.CharacterRemoteDataSource
import com.junka.core.domain.character.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {

    override suspend fun fetchCharacters(): Result<List<Character>, DataError.Network> {
        return remoteDataSource.getCharacters()
    }
}