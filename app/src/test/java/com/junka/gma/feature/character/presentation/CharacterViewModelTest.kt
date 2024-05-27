package com.junka.gma.feature.character.presentation

import com.junka.gma.feature.character.data.CharacterRepositoryImpl
import com.junka.gma.feature.character.presentation.CharacterAction
import com.junka.gma.feature.character.presentation.CharacterState
import com.junka.gma.feature.character.presentation.CharacterViewModel
import com.junka.testing.character.FakeCharacterRemoteDataSource
import com.junka.testing.character.fakeCharacters
import com.junka.testing.testrule.CoroutinesTestRule
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