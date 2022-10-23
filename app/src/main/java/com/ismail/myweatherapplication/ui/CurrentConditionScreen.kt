package com.ismail.myweatherapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ismail.myweatherapplication.R

@Composable
fun CurrentConditionsScreen(
    cityName: String,
    current_temp: Int,
    onNavigate: () -> Unit

) {


    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(

            modifier = Modifier
                .padding(16.dp),


            text = cityName,
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
                    text = stringResource(id = R.string.degree_symbol, current_temp),
                    style = TextStyle(
                        fontSize = 72.sp,
                        fontWeight = FontWeight(600)
                    )
                )

                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text = stringResource(id = R.string.feels_like_temp, 77),
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontWeight = FontWeight(400)
                    )
                )
            }



            Spacer(modifier = Modifier.weight(1.0f, true))
            Image(
                modifier = Modifier
                    .size(95.dp)
                    .padding(vertical = 10.dp),

                painter = painterResource(id = R.drawable.sun_icon),
                contentDescription = "Sunny"
            )


        }



        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(vertical = 20.dp)


        ) {

            Text(text = stringResource(id = R.string.low_temp, 66))
            Text(text = stringResource(id = R.string.high_temp, 76))
            Text(text = stringResource(id = R.string.humidity, 100))
            Text(text = stringResource(id = R.string.pressure, 56))

        }



        Spacer(modifier = Modifier.weight(1.0f, true))

        Button(modifier = Modifier.padding(bottom = 20.dp),
            onClick = {

                onNavigate()
            })
        {
            Text(text = "Forecast")

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
    CurrentConditionsScreen(
        cityName = "St. Paul, MN",
        current_temp = 72,
        {})
}