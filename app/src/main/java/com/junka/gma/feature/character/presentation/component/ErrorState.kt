package com.junka.gma.feature.character.presentation.component

import androidx.annotation.RawRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.junka.gma.core.presentation.designsystem.GMATheme

@Composable
fun ErrorState(
    @RawRes raw: Int? = null,
    errorText: String,
    bottomContent: (@Composable ColumnScope.() -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (raw != null) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(raw))
            LottieAnimation(
                modifier = Modifier
                    .size(240.dp)
                    .padding(16.dp),
                composition = composition,
                iterations = LottieConstants.IterateForever,
                speed = 0.7f
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        Text(
            text = errorText,
            color = MaterialTheme.colorScheme.error,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        if (bottomContent != null) {
            Spacer(modifier = Modifier.height(16.dp))
            bottomContent()
        }

    }
}

@Preview
@Composable
fun ErrorStatePreview() {
    GMATheme {
        ErrorState(
            errorText = "Error"
        )
    }
}