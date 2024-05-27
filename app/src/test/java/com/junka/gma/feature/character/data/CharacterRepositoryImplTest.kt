package com.junka.gma.feature.character.data

import com.junka.gma.core.domain.Result
import com.junka.testing.character.FakeCharacterRemoteDataSource
import com.junka.testing.character.fakeCharacters
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class CharacterRepositoryImplTest {

    @Test
    fun `when getCharacters is called then return remote source data`() {
        val remoteDataSource = FakeCharacterRemoteDataSource(fakeCharacters)
        val repository = CharacterRepositoryImpl(remoteDataSource)
        val result = runBlocking { repository.fetchCharacters() }

        assertEquals(fakeCharacters, (result as Result.Success).data)
    }
}