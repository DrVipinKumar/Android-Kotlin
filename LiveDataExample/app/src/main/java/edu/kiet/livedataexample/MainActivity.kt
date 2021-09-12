package edu.kiet.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.kiet.livedataexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var counterProvider: Counter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        counterProvider=ViewModelProvider(this).get(Counter::class.java)
        binding.counter=counterProvider
        binding.lifecycleOwner=this
        binding.btnStartCountDown.setOnClickListener(View.OnClickListener {
            if(!binding.txtStartValue.text.isEmpty())
            {
                counterProvider.startValue=binding.txtStartValue.text.toString().toLong()*1000
                counterProvider.startTimer()
            }
            else
            {
                Toast.makeText(applicationContext,"Please Insert Start Counter Value",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnStopCountDown.setOnClickListener(View.OnClickListener {
            counterProvider.stopTimer()
        })
      /*  counterProvider.seconds().observe(this,{
            binding.txtCountValue.text=it.toString()
        })*/
    }
}