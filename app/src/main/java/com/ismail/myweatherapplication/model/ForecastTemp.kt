package com.ismail.myweatherapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastTemp(val min : Float, val max: Float) : Parcelable
