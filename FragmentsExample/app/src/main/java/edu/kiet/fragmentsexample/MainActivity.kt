package edu.kiet.fragmentsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import edu.kiet.fragmentsexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnFr1.setOnClickListener(View.OnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,Fragment1()).commit()
        })
        binding.btnFr2.setOnClickListener(View.OnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,Fragment2()).commit()
        })

    }
}