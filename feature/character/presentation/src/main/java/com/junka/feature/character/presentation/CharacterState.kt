package com.junka.feature.character.presentation

import com.junka.core.domain.character.Character
import com.junka.core.presentation.ui.UiText

data class CharacterState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error : UiText? = null
)