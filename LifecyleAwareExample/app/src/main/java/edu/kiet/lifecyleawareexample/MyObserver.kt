package edu.kiet.lifecyleawareexample

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver(var context: Context):LifecycleObserver{
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate()
    {
       // Log.d("Observer","I am in OnCreate function of Observer")
        Toast.makeText(context.applicationContext,"I am in OnCreate Observer",Toast.LENGTH_SHORT).show()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume()
    {
        Log.d("Observer","I am in OnResume function of Observer")
    }

}