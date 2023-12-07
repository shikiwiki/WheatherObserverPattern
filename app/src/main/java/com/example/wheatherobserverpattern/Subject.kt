package com.example.wheatherobserverpattern

interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
    fun notifyObservers(o: Any?)
}