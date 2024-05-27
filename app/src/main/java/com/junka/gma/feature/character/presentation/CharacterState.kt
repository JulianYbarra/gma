package com.junka.gma.feature.character.presentation

import com.junka.gma.core.presentation.ui.UiText
import com.junka.gma.feature.character.domain.Character

data class CharacterState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: UiText? = null
)