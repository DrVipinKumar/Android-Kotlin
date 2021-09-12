package edu.kiet.floatingactionbuttonex

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import com.google.android.material.snackbar.Snackbar
import edu.kiet.floatingactionbuttonex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.floatingActionButton.setOnClickListener(View.OnClickListener {
            val snackbar=Snackbar.make(binding.consLayout,"This is toast under Floating Action Button",Snackbar.LENGTH_SHORT)
            snackbar.setAction("Show Toast",{
                Toast.makeText(applicationContext,"Toast under SnackBar",Toast.LENGTH_SHORT).show()
            })
            snackbar.setActionTextColor(Color.RED)
            val view=snackbar.view
            val textview=view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textview.setTextColor(Color.YELLOW)
            snackbar.show()
        })

    }
}