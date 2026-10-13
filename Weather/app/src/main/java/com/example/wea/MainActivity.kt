package com.example.wea

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var selectedCityTextView: TextView
    private lateinit var chooseCityButton: Button
    private lateinit var enterCityEditText: EditText
    private lateinit var currentWeatherTextView: TextView
    private lateinit var currentWeatherTextViewWeather: TextView
    private lateinit var hourlyWeatherLayout: LinearLayout
    private lateinit var getWeatherButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        supportActionBar?.hide()

        selectedCityTextView = findViewById(R.id.selectedCityTextView)
        currentWeatherTextView = findViewById(R.id.currentWeatherTextView)
        currentWeatherTextViewWeather = findViewById(R.id.currentWeatherTextViewWeather)
        enterCityEditText = findViewById(R.id.enterCityEditText)
        chooseCityButton = findViewById(R.id.chooseCityButton)
        getWeatherButton = findViewById(R.id.getWeatherButton)
        hourlyWeatherLayout = findViewById(R.id.hourly_weather_layout)

        selectedCityTextView.text = "Your Sity: Kaluga"

        chooseCityButton.setOnClickListener {
            if (enterCityEditText.visibility == View.VISIBLE && getWeatherButton.visibility == View.VISIBLE) {
                enterCityEditText.visibility = View.GONE
                getWeatherButton.visibility = View.GONE
            } else {
                enterCityEditText.visibility = View.VISIBLE
                getWeatherButton.visibility = View.VISIBLE
            }
        }

        getWeatherButton.setOnClickListener {
            val newCity = enterCityEditText.text.toString().trim()
            if (newCity.isEmpty()) {
                Toast.makeText(this, "Please, enter city name", Toast.LENGTH_SHORT).show()
            } else {
                if (isNetworkAvailable()) {
                    val app = WeatherApp(BuildConfig.WEATHER_API_KEY)
                    app.getCurrentWeather(newCity, object : WeatherApp.WeatherCallback {
                        override fun onCurrentWeatherReceived(temperature: Int, description: String) {
                            runOnUiThread {
                                selectedCityTextView.text = "Your City: ${newCity.toLowerCase().capitalize()}" // Обновляем название города
                                currentWeatherTextView.text = "Current Weather in ${newCity.toLowerCase().capitalize()}:" // Обновляем текст о погоде
                                currentWeatherTextViewWeather.text = "$temperature°C, $description" // Обновляем текст о погоде
                                enterCityEditText.setText("")
                                enterCityEditText.visibility = View.GONE
                                getWeatherButton.visibility = View.GONE
                                updateWeather(newCity)
                            }
                        }

                        override fun onCurrentWeatherReceivedError(errorCode: Int) {
                            runOnUiThread {
                                if (errorCode == 404) {
                                    Toast.makeText(this@MainActivity, "City not found", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    })
                }
            }
        }
        updateWeather("Kaluga")
    }

    private fun updateWeather(city: String) {
        if (isNetworkAvailable()) {
            val app = WeatherApp(BuildConfig.WEATHER_API_KEY)
            app.getCurrentWeather(city, object : WeatherApp.WeatherCallback {
                override fun onCurrentWeatherReceived(temperature: Int, description: String) {
                    runOnUiThread {
                        selectedCityTextView.text = "Your Sity: ${city.toLowerCase().capitalize()}" // Обновляем название города
                        currentWeatherTextView.text = "Current Weather in ${city.toLowerCase().capitalize()}:" // Обновляем текст о погоде
                        currentWeatherTextViewWeather.text = "$temperature°C, $description" // Обновляем текст о погоде
                    }
                }

                override fun onCurrentWeatherReceivedError(errorCode: Int) {
                }
            })

            app.getHourlyWeather(city, object : WeatherApp.HourlyWeatherCallback {
                override fun onHourlyWeatherReceived(hourlyWeather: List<HourlyWeather>) {
                    runOnUiThread {
                        hourlyWeatherLayout.removeAllViews()
                        for (weather in hourlyWeather) {
                            val view = layoutInflater.inflate(R.layout.hourly_weather_layout, null)
                            val dateAndTimeTextView = view.findViewById<TextView>(R.id.dateAndTimeTextView)
                            val temperatureTextView = view.findViewById<TextView>(R.id.temperatureTextView)
                            val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)

                            dateAndTimeTextView.text = "${weather.time}"
                            temperatureTextView.text = "${weather.temperature}°C"
                            descriptionTextView.text = "${weather.description}"

                            hourlyWeatherLayout.addView(view)
                        }
                    }
                }
            })
        } else {
            Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
        }
    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}