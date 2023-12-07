package com.example.wheatherobserverpattern

interface Observer {
    fun update(weatherData: WeatherData, arg: Any)
}