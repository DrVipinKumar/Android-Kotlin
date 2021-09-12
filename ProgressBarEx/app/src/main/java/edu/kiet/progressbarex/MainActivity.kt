package edu.kiet.progressbarex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import edu.kiet.progressbarex.databinding.ActivityMainBinding

lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener(View.OnClickListener {
            var value=0
            Thread(Runnable {
                while(value<=1000)
                {
                    value=value+10;
                    Thread.sleep(1000)
                    binding.progressBar.setProgress(value)
                }
            }).start()
        })

    }
}