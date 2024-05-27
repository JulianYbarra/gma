package com.junka.core.data

import com.junka.core.data.character.CharacterRepositoryImpl
import com.junka.core.domain.Result
import com.junka.core.testing.data.FakeCharacterRemoteDataSource
import com.junka.core.testing.fakeCharacters
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