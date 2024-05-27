package com.junka.gma.feature.character.data

import com.junka.gma.core.domain.DataError
import com.junka.gma.core.domain.Result
import com.junka.gma.feature.character.domain.Character
import com.junka.gma.feature.character.domain.CharacterRemoteDataSource
import com.junka.gma.feature.character.domain.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {

    override suspend fun fetchCharacters(): Result<List<Character>, DataError.Network> {
        return remoteDataSource.getCharacters()
    }
}