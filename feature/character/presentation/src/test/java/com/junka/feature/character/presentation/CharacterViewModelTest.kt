package com.junka.feature.character.presentation

import com.junka.core.data.character.CharacterRepositoryImpl
import com.junka.core.testing.data.FakeCharacterRemoteDataSource
import com.junka.core.testing.data.FakeCharacterRepository
import com.junka.core.testing.fakeCharacters
import com.junka.core.testing.testrule.CoroutinesTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private lateinit var viewModel: CharacterViewModel

    @Before
    fun setup() {
        val remoteDataSource = FakeCharacterRemoteDataSource(fakeCharacters)
        val repository = CharacterRepositoryImpl(remoteDataSource)
        viewModel = CharacterViewModel(repository)
    }

    @Test
    fun `when viewmodel start then fetch characters`() = runTest {
        assertEquals(CharacterState(), viewModel.state)
        viewModel.onAction(CharacterAction.OnStart)
        assertEquals(
            CharacterState(
                isLoading = true,
                characters = emptyList(),
                error = null
            ), viewModel.state
        )
        runCurrent()
        assertEquals(
            CharacterState(isLoading = false, characters = fakeCharacters, error = null),
            viewModel.state
        )
    }

    @Test
    fun `when try again then show loading and fetch characters`() = runTest {
        viewModel.onAction(CharacterAction.OnTryAgain)
        runCurrent()
        assertEquals(
            CharacterState(isLoading = false, characters = fakeCharacters, error = null),
            viewModel.state
        )
    }


}