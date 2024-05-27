package com.junka.core.data.character

import com.junka.core.data.mapper.toCharacter
import com.junka.core.data.network.safeCall
import com.junka.core.domain.DataError
import com.junka.core.domain.Result
import com.junka.core.domain.character.Character
import com.junka.core.domain.character.CharacterRemoteDataSource
import javax.inject.Inject

class CharacterRemoteDataSourceImp @Inject constructor(
    private val characterService: CharacterService
) : CharacterRemoteDataSource {
    override suspend fun getCharacters(): Result<List<Character>, DataError.Network> {
        return safeCall {
            characterService.getCharacters().results.map { it.toCharacter() }
        }
    }
}