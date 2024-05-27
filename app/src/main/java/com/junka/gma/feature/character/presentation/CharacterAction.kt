package com.junka.gma.feature.character.presentation

sealed interface CharacterAction {
    data object OnTryAgain : CharacterAction
    data object OnStart : CharacterAction
}