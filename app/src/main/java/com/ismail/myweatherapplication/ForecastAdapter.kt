package com.ismail.myweatherapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class ForecastAdapter(private val data: List<DayForecast>) : RecyclerView.Adapter<ForeCastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForeCastViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.view_forecast_item, parent, false)
        return ForeCastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForeCastViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size


}

class ForeCastViewHolder(view : View) : RecyclerView.ViewHolder(view){
  private val forecastDate: TextView
  private val forecastHighTemp: TextView
  private val forecastLowTemp: TextView
  private val forecastCurrentTemp: TextView
  private val forecastSunrise : TextView
  private val  forecastSunset : TextView


  init {
      forecastDate = view.findViewById(R.id.forecast_date)
      forecastHighTemp = view.findViewById(R.id.forecast_high_temp)
      forecastLowTemp = view.findViewById(R.id.forecast_low_temp)
      forecastCurrentTemp = view.findViewById(R.id.forecast_temp)
      forecastSunrise = view.findViewById(R.id.forecast_sunrise)
      forecastSunset = view.findViewById(R.id.forecast_sunset)


  }

    fun bind(data : DayForecast){
        forecastDate.text = getDateFormat(data.date)
        forecastLowTemp.text = "Low " + data.temp.min.toString()
        forecastHighTemp.text ="High " + data.temp.max.toString()
        forecastSunset.text =  " Sunset " + geTimeFormat(data.sunset)
        forecastSunrise.text = " SunRise " + geTimeFormat(data.sunrise)
        itemView.resources.getString(R.string.degree_temp, 60)

    }

    fun getDateFormat(date : Long) : String{
        val formatter = DateTimeFormatter.ofPattern("MMM dd")
        val dateTime = LocalDateTime.ofEpochSecond(date, 0, ZoneOffset.of("-5"))
        val formatData = formatter.format(dateTime)
        Log.d("dtab", formatData)
        return formatData
    }

    fun geTimeFormat(date: Long) : String{
        val dateTime = LocalDateTime.ofEpochSecond(date, 0, ZoneOffset.of("-5"))
        val timeFormatter = DateTimeFormatter.ofPattern("h:mm a")
        val formatTime = timeFormatter.format(dateTime)
        return formatTime
    }
}
