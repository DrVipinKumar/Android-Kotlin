package edu.kiet.livedataexample

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Counter: ViewModel() {
    lateinit var timer:CountDownTimer
    private val _seconds=MutableLiveData<Int>()
    var startValue:Long=0
    fun startTimer()
    {
        timer=object:CountDownTimer(startValue,1000){
            override fun onTick(value: Long) {
                val count=value/1000
                _seconds.value=count.toInt()
            }

            override fun onFinish() {

            }

        }.start()

    }
    fun stopTimer()
    {
        timer.cancel()
    }
    fun seconds(): LiveData<Int>
    {
        return _seconds
    }

}