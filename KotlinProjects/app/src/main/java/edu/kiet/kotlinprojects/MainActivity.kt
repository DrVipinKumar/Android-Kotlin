package edu.kiet.kotlinprojects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ViewSwitcher
import edu.kiet.kotlinprojects.databinding.ActivityMainBinding

lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var i=0;
        var data= arrayListOf<String>("Android", "Windows","Linux","MAC OS")

        binding.btnNext.setOnClickListener(View.OnClickListener {
            if(i<data.size) {
                binding.textSwitcher.setCurrentText(data[i++])

            }

        })

        binding.btnPrevious.setOnClickListener(View.OnClickListener {
            if(i>0) {

                binding.textSwitcher.setCurrentText(data[--i])


            }

        })
    }
}