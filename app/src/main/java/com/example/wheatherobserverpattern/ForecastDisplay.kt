package com.example.wheatherobserverpattern

import java.util.logging.Level
import java.util.logging.Logger

class ForecastDisplay(weatherData: Subject) : Observer, DisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        display()
    }

    override fun display() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
            .log(Level.INFO, "Forecast...")
    }
}