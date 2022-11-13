package com.ismail.myweatherapplication.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ismail.myweatherapplication.R
import com.ismail.myweatherapplication.model.ForecastData
import com.ismail.myweatherapplication.util.toHourMinute
import com.ismail.myweatherapplication.util.toMonthDay


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForecastScreen(
    viewModel: ForecastViewModel = hiltViewModel(),
) {

    val state by viewModel.forecastConditions.collectAsState(null)


    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }
    Scaffold(
        topBar = { AppBar(title = stringResource(id = R.string.app_name))},
    ) {
        state?.let {
            it
            LazyColumn {
                items(items = it.forecastData) { item: ForecastData ->
                    ForecastItem(item = item)

                }
            }
        }
    }

}


@Composable

fun ForecastItem(item: ForecastData) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val textStyle = TextStyle(fontSize = 12.sp)

        val iconUrl = String.format(
            "https://openweathermap.org/img/wn/10d@2x.png",
            item.weatherData.firstOrNull()?.iconName
        )

        AsyncImage(
            model = iconUrl,
            contentDescription = "Sunny",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.weight(1f, true))
        Text(text = item.date.toMonthDay(), style = TextStyle(fontSize = 16.sp))

        Spacer(modifier = Modifier.weight(1f, true))


        Column {
            Text(
                text = stringResource(id = R.string.current_temp, item.temp.min.toInt()),
                style = textStyle
            )
            Row {
                Text(
                    text = stringResource(id = R.string.high_temp, item.temp.max.toInt()),
                    style = textStyle
                )


                Text(
                    text = stringResource(id = R.string.low_temp, item.temp.min.toInt()),
                    modifier = Modifier.padding(horizontal = 10.dp),
                    style = textStyle
                )


            }

            Spacer(modifier = Modifier.weight(1f, true))


        }



        Spacer(modifier = Modifier.weight(1f, true))
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = stringResource(id = R.string.sun_rise, item.sunrise.toHourMinute()),
                style = textStyle
            )
            Text(
                text = stringResource(id = R.string.sun_set, item.sunset.toHourMinute()),
                style = textStyle
            )
        }
    }

}


@Preview(
    name = "ForestScreen",
    device = Devices.PIXEL_4,
    showBackground = true,
    showSystemUi = true
)

@Composable
fun ForestScreenPreview() {

    ForecastScreen()
}


