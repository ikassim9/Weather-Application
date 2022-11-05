package com.ismail.myweatherapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ismail.myweatherapplication.R
import com.ismail.myweatherapplication.model.DayForecast
import com.ismail.myweatherapplication.model.ForecastTemp
import com.ismail.myweatherapplication.util.toHourMinute
import com.ismail.myweatherapplication.util.toMonthDay

const val startDay = 1666474687L
const val sunRise = 24444222L
const val sunSet = 24444222L

val forecastData = (0 until 16).map {
    DayForecast(
        date = startDay * (it * (24 * 68 * 68)),
        sunrise = sunRise * (it * (24 * 68 * 68)),
        sunset = sunSet * (it * (24 * 63 * 68)),
        temp = ForecastTemp(
            min = 60F + it,
            max = 78F + it
        ),
        humidity = 100,
        pressure = 62F
    )
}


@Composable
fun ForecastScreen() {

    LazyColumn {
        items(items = forecastData) { item: DayForecast ->
            ForecastItem(item = item)

        }
    }
}


@Composable

fun ForecastItem(item: DayForecast) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val textStyle = TextStyle(fontSize = 12.sp)

        Image(painter = painterResource(id = R.drawable.sun_icon), contentDescription = "")
        Spacer(modifier = Modifier.weight(1f, true))
        Text(text = item.date.toMonthDay(), style = TextStyle(fontSize = 16.sp))

        Spacer(modifier = Modifier.weight(1f, true))


        Column {
            Text(text = stringResource(id = R.string.current_temp, item.temp.min.toInt() + 2), style = textStyle)
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


