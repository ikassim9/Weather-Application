package com.ismail.myweatherapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ismail.myweatherapplication.ui.CurrentConditionsScreen
import com.ismail.myweatherapplication.ui.ForecastScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "CurrentConditions"){
                composable("CurrentConditions"){
                    CurrentConditionsScreen(cityName = "Minneapolis", current_temp = 76, ) {
                        navController.navigate("Forecast")
                    }
                }

                composable("Forecast"){
                    ForecastScreen()
                }
            }


        }


    }
}