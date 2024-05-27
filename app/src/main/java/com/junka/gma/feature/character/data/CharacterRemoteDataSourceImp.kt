package com.junka.gma.feature.character.data

import com.junka.gma.core.domain.DataError
import com.junka.gma.core.domain.Result
import com.junka.gma.feature.character.data.mapper.toCharacter
import com.junka.gma.core.data.network.safeCall
import com.junka.gma.feature.character.domain.Character
import com.junka.gma.feature.character.domain.CharacterRemoteDataSource
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