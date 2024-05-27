package com.junka.feature.character.presentation

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.junka.core.presentation.ui.UiText
import com.junka.core.testing.fakeCharacters
import org.junit.Rule
import org.junit.Test


class CharacterScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun whenStateIsLoading_showsLoadingSpinner(): Unit = with(composeTestRule) {
        setContent {
            CharacterScreen(
                state = CharacterState(isLoading = true),
                onAction = {}
            )
        }

        onNodeWithTag("loader")
            .assertExists()
    }

    @Test
    fun whenHasError_showsErrorState(): Unit = with(composeTestRule) {
        setContent {
            CharacterScreen(
                state = CharacterState(error = UiText.DynamicString("No internet Connection")),
                onAction = {}
            )
        }

        onNodeWithText("No internet Connection")
            .assertExists()

        onNodeWithText("Try again")
            .assertExists()
    }

    @Test
    fun whenHasCharacters_showsItems(): Unit = with(composeTestRule) {
        setContent {
            CharacterScreen(
                state = CharacterState(characters = fakeCharacters),
                onAction = {}
            )
        }

        onNodeWithTag(CHARACTER_TEST_TAG + fakeCharacters[0].id)
            .assertExists()
        onNodeWithTag(CHARACTER_TEST_TAG + fakeCharacters[1].id)
            .assertExists()
        onNodeWithTag(CHARACTER_TEST_TAG + fakeCharacters[2].id)
            .assertExists()
    }
}