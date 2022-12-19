package com.ismail.myweatherapplication.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ismail.myweatherapplication.R
import com.ismail.myweatherapplication.model.CurrentConditions
import com.ismail.myweatherapplication.model.LatitudeLongitude

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditionsScreen(
    latitudeLongitude: LatitudeLongitude?,
    viewModel: CurrentConditionsViewModel = hiltViewModel(),
    onGetWeatherForMyLocationClick: () -> Unit,
    onForecastButtonClick: () -> Unit,

    ) {

    val state by viewModel.currentConditions.collectAsState(null)


    if (latitudeLongitude != null) {
        LaunchedEffect(Unit) {
            viewModel.fetchDataByLocation(latitudeLongitude)
        }
    } else {
        LaunchedEffect(Unit) {
            viewModel.fetchData()
        }
    }


    Scaffold(
        topBar = { AppBar(title = stringResource(id = R.string.app_name)) },
    ) {
        state?.let {
            CurrentConditionsContent(it, onGetWeatherForMyLocationClick, onForecastButtonClick)
        }
    }

}


@Composable
fun CurrentConditionsContent(
    currentConditions: CurrentConditions,
    onGetWeatherForMyLocationClick: () -> Unit,
    onForecastButtonClick: () -> Unit,


    ) {


    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(

            modifier = Modifier
                .padding(16.dp),


            text = currentConditions.cityName,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400)
            )
        )



        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically


        ) {
            Column() {

                Text(
                    text = stringResource(
                        R.string.temperature,
                        currentConditions.conditions.temperature
                    ),
                    style = TextStyle(
                        fontSize = 72.sp,
                        fontWeight = FontWeight(600)
                    )
                )

                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text = stringResource(
                        id = R.string.feels_like_temp,
                        currentConditions.conditions.feelsLike.toInt()
                    ),
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontWeight = FontWeight(400)
                    )
                )
            }



            Spacer(modifier = Modifier.weight(1.0f, true))
            val iconUrl = String.format(
                "https://openweathermap.org/img/wn/10d@2x.png",
                currentConditions.weatherData.firstOrNull()?.iconName
            )
            AsyncImage(
                model = iconUrl,
                contentDescription = "Sunny",
                modifier = Modifier.size(72.dp),
                contentScale = ContentScale.Fit
            )

        }



        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(vertical = 20.dp)


        ) {

            Text(
                text = stringResource(
                    id = R.string.low_temp,
                    currentConditions.conditions.minTemperature.toInt()
                )
            )
            Text(
                text = stringResource(
                    id = R.string.high_temp,
                    currentConditions.conditions.maxTemperature.toInt()
                )
            )
            Text(
                text = stringResource(
                    id = R.string.humidity,
                    currentConditions.conditions.humidity.toInt()
                )
            )
            Text(
                text = stringResource(
                    id = R.string.pressure,
                    currentConditions.conditions.pressure.toInt()
                )
            )

        }



        Spacer(modifier = Modifier.weight(1.0f, true))

        Button(modifier = Modifier.padding(bottom = 20.dp),
            onClick = {

                onForecastButtonClick()
            })
        {
            Text(text = "Forecast")

        }

        Button(onClick = onGetWeatherForMyLocationClick) {

            Text(text = "Get Weather for My Location")
        }

    }


}


@Preview(
    name = "currentConditions",
    device = Devices.PIXEL_4,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CurrentConditionsScreenPreview() {


}