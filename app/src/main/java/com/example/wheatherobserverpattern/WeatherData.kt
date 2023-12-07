package com.example.wheatherobserverpattern

open class WeatherData : Subject {
    private var observers: ArrayList<Observer> = ArrayList()
    var temperature: Float = 0.0f
    var humidity: Float = 0.0f
    var pressure: Float = 0.0f
    private var changed: Boolean = false


    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        val i = observers.indexOf(observer)
        if (i >= 0) {
            observers.removeAt(i)
        }
    }

    override fun notifyObservers() {
        notifyObservers(null)
    }

    override fun notifyObservers(o: Any?) {
        if (changed) {
            observers.forEach { i -> i.update(temperature, humidity, pressure) }
        }
        changed = false
    }

    fun measurementsChanged() {
        setChanged()
        notifyObservers()
    }

    fun setMeasurements(t: Float, h: Float, p: Float) {
        temperature = t
        humidity = h
        pressure = p
        measurementsChanged()
    }

    fun setChanged() {
        changed = true
    }
}