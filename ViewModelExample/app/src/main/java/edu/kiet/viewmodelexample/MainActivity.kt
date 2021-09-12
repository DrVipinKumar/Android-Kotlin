package edu.kiet.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    lateinit var incrementVM:Increment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnIncrement=findViewById<Button>(R.id.btnIncrements)
        val textCounter=findViewById<TextView>(R.id.txtCounterValue)
        incrementVM=ViewModelProvider(this,IncrementFactory(10)).get(Increment::class.java)
        textCounter.text=incrementVM.count.toString()
        btnIncrement.setOnClickListener(View.OnClickListener {
              textCounter.text=incrementVM.counter().toString()
        })


    }



}