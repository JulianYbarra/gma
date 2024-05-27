package com.junka.feature.character.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junka.core.domain.Result
import com.junka.core.domain.character.CharacterRepository
import com.junka.core.presentation.ui.asUiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    var state by mutableStateOf(CharacterState())
        private set

    fun onAction(action: CharacterAction) {
        when (action) {
            CharacterAction.OnStart, CharacterAction.OnTryAgain -> fetchCharacters()
        }
    }

    private fun fetchCharacters() {
        state = state.copy(error = null, isLoading = true)
        viewModelScope.launch {
            when (val result = repository.fetchCharacters()) {
                is Result.Failure -> {
                    state = state.copy(error = result.error.asUiText())
                }

                is Result.Success -> {
                    state = state.copy(characters = result.data)
                }
            }
            state = state.copy(isLoading = false)
        }
    }
}