package edu.kiet.lifecyleawareexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(MyObserver(this))
       // Log.d("Observer","I am in OnCreate function of MainActivity")
        Toast.makeText(applicationContext,"I am in OnCreate in MainActivity",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("Observer","I am in OnResume function of MainActivity")
    }
}