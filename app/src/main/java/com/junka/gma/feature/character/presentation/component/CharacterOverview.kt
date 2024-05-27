package com.junka.gma.feature.character.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.junka.gma.R
import com.junka.gma.core.presentation.designsystem.Black40
import com.junka.gma.core.presentation.designsystem.GMATheme
import com.junka.gma.core.presentation.designsystem.Green
import com.junka.gma.core.presentation.designsystem.Red
import com.junka.gma.feature.character.domain.StatusEnum

@Composable
fun CharacterOverview(
    modifier: Modifier = Modifier,
    name: String,
    status: StatusEnum,
    location: String,
    imgUrl: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(8.dp)
    ) {
        CharacterImage(
            imageUrl = imgUrl
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            Text(
                text = name,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            CharacterStatus(status = status)
            Spacer(modifier = Modifier.height(4.dp))
            DetailGridCell(
                name = stringResource(id = R.string.last_known_location),
                value = location
            )
        }
    }
}

@Composable
private fun CharacterStatus(
    modifier: Modifier = Modifier,
    status: StatusEnum
) {
    val color = when (status) {
        StatusEnum.ALIVE -> Green
        StatusEnum.DEAD -> Red
        StatusEnum.UNKNOWN -> Black40
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(color.copy(alpha = 0.3f)),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(color)
                    .padding(4.dp),
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = status.name,
            fontSize = 10.sp
        )
    }

}

@Composable
private fun DetailGridCell(
    name: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = name.uppercase(),
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 9.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = value,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun CharacterImage(
    modifier: Modifier = Modifier,
    imageUrl: String
) {
    SubcomposeAsyncImage(
        modifier = modifier
            .size(120.dp)
            .clip(RoundedCornerShape(15.dp)),
        model = imageUrl,
        loading = {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(20.dp),
                strokeWidth = 2.dp,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        contentDescription = stringResource(id = R.string.character),
        error = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.errorContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.error_couldnt_load_image),
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    )
}

@Preview
@Composable
fun CharacterOverviewPreview() {
    GMATheme {
        CharacterOverview(
            name = "Rick",
            status = StatusEnum.ALIVE,
            location = "Earth",
            imgUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        )
    }
}