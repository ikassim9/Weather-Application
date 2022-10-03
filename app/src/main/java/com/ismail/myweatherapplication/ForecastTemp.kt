package com.ismail.myweatherapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ForecastTemp(val min : Float, val max: Float) : Parcelable

