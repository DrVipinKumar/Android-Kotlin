package edu.kiet.switchandtoggleex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import edu.kiet.switchandtoggleex.databinding.ActivityMainBinding

lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.switch1.setOnClickListener(View.OnClickListener {
            if(binding.switch1.isChecked)
            {
                Toast.makeText(applicationContext,"Your Enabled Switch",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(applicationContext,"Your Disabled Switch",Toast.LENGTH_SHORT).show();
            }
        })
        binding.toggleButton.setOnClickListener(View.OnClickListener {
            if(binding.toggleButton.isChecked)
            {
                Toast.makeText(applicationContext,"Your Enabled Toggle",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(applicationContext,"Your Disabled Toggle",Toast.LENGTH_SHORT).show();
            }
        })
        
    }
}