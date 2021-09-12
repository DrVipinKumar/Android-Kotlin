package edu.kiet.viewmodelexample

import androidx.lifecycle.ViewModel

class Increment(val initial:Int): ViewModel() {
    var count =initial
    fun counter():Int
    {
        return ++count
    }
}