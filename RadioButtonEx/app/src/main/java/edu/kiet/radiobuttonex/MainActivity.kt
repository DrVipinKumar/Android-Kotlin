package edu.kiet.radiobuttonex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.kiet.radiobuttonex.databinding.ActivityMainBinding

lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when{
                checkedId==R.id.rdPython->
                    Toast.makeText(applicationContext,"You selected Python",Toast.LENGTH_SHORT).show()
                checkedId==R.id.rdKotlin->
                    Toast.makeText(applicationContext,"You selected Kotlin",Toast.LENGTH_SHORT).show()
                checkedId==R.id.rdJava->
                    Toast.makeText(applicationContext,"You selected Java",Toast.LENGTH_SHORT).show()
            }
        }
    }
}