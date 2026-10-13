package com.example.wea

import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class WeatherApp(val apiKey: String) {
    private val client = OkHttpClient()

    interface WeatherCallback {
        fun onCurrentWeatherReceived(temperature: Int, description: String)
        fun onCurrentWeatherReceivedError(errorCode: Int)
    }

    interface HourlyWeatherCallback {
        fun onHourlyWeatherReceived(hourlyWeather: List<HourlyWeather>)
    }

    fun getCurrentWeather(city: String, callback: WeatherCallback) {
        val url = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey"

        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val responseCode = response.code
                response.body?.let {
                    if (response.isSuccessful) {
                        val json = JSONObject(it.string())
                        val temperatureKelvin = json.getJSONObject("main").getDouble("temp")
                        val temperatureCelsius = (temperatureKelvin - 273.15).toInt()
                        val description = json.getJSONArray("weather").getJSONObject(0).getString("description")
                        callback.onCurrentWeatherReceived(temperatureCelsius, description)
                    } else {
                        Log.e("AndroidRuntime", "Error occurred: $responseCode")
                        callback.onCurrentWeatherReceivedError(responseCode)
                    }
                }
            }
        })
    }

    fun getHourlyWeather(city: String, callback: HourlyWeatherCallback) {
        val url = "https://api.openweathermap.org/data/2.5/forecast?q=$city&appid=$apiKey"

        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val responseCode = response.code
                response.body?.let {
                    if (response.isSuccessful) {
                        val json = JSONObject(it.string())
                        val list = json.getJSONArray("list")
                        val hourlyWeatherList = mutableListOf<HourlyWeather>()
                        for (i in 0 until list.length()) {
                            val weather = list.getJSONObject(i)
                            val temperatureKelvin = weather.getJSONObject("main").getDouble("temp")
                            val temperatureCelsius = temperatureKelvin - 273.15
                            val description = weather.getJSONArray("weather").getJSONObject(0).getString("description")
                            val time = weather.getString("dt_txt").split(" ")[1].substring(0, 5)
                            hourlyWeatherList.add(HourlyWeather(time, temperatureCelsius.toInt(), description))
                        }
                        callback.onHourlyWeatherReceived(hourlyWeatherList)
                    }
                    else {
                        Log.e("AndroidRuntime", "Error occurred: $responseCode")
                    }
                }
            }
        })
    }
}

data class HourlyWeather(val time: String, val temperature: Int, val description: String)