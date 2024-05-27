package com.junka.gma.feature.character.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.junka.gma.R
import com.junka.gma.core.presentation.designsystem.GMATheme
import com.junka.gma.core.presentation.designsystem.component.GMAButton
import com.junka.gma.feature.character.presentation.component.CharacterOverview
import com.junka.gma.feature.character.presentation.component.ErrorState

@Composable
fun CharacterScreenRoot(
    viewModel: CharacterViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onAction(CharacterAction.OnStart)
    }

    CharacterScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
    )
}

@Composable
fun CharacterScreen(
    state: CharacterState,
    onAction: (CharacterAction) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = state.characters,
                key = { it.id }
            ) { character ->
                CharacterOverview(
                    modifier = Modifier
                        .testTag(CHARACTER_TEST_TAG + character.id),
                    name = character.name,
                    status = character.status,
                    location = character.lastLocation,
                    imgUrl = character.image
                )
            }
        }

        if (state.error != null) {
            ErrorState(
                raw = R.raw.morty,
                errorText = state.error.asString(),
                bottomContent = {
                    GMAButton(
                        text = stringResource(id = R.string.try_again),
                        onClick = { onAction(CharacterAction.OnTryAgain) }
                    )
                }
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(20.dp)
                    .testTag("loader"),
                strokeWidth = 2.dp,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

}

const val CHARACTER_TEST_TAG = "character_"

@Preview
@Composable
private fun CharacterScreenPreview() {
    GMATheme {
        CharacterScreen(
            state = CharacterState(),
            onAction = {}
        )
    }
}