package com.example.wheatherobserverpattern

import java.util.logging.Level
import java.util.logging.Logger

class CurrentConditionsDisplay(weatherData: Subject) : Observer, DisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(weatherData: WeatherData, arg: Any) {
        temperature = weatherData.temperature
        humidity = weatherData.humidity
        display()
    }

    override fun display() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
            .log(Level.INFO, "Current conditions: temperature $temperature C degrees and $humidity% hunidity")
    }
}