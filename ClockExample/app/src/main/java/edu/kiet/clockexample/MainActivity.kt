package edu.kiet.clockexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.TimePicker
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val chronometer=findViewById(R.id.chronometer) as Chronometer
        val star=findViewById(R.id.btnStart) as Button
        val stop=findViewById(R.id.btnStop) as Button
        star.setOnClickListener(View.OnClickListener {
            chronometer.base=SystemClock.elapsedRealtime()
            chronometer.start()
        })
        stop.setOnClickListener(View.OnClickListener {
            chronometer.stop()
        })
    }
}