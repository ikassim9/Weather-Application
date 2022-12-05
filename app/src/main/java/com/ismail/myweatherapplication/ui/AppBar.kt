package com.ismail.myweatherapplication.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable

fun AppBar(
    title: String
) {

    TopAppBar(
        backgroundColor = Color.Blue

        ) {
        Text(
            text = title,
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight(700)
            )
        )

    }
}

@Preview
@Composable

fun prev() {
    AppBar(title = "Weather App")
}