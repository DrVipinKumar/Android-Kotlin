package edu.kiet.eventbusexample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import org.greenrobot.eventbus.EventBus

class Addition : Service() {


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val num1=intent?.getIntExtra("num1",10)
        val num2=intent?.getIntExtra("num2",10)
        val sum=num1!!+num2!!;
        EventBus.getDefault().post(ResultData(sum))
        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}