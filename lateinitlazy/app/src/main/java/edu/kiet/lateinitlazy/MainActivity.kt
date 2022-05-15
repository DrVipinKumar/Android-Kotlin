package edu.kiet.lateinitlazy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.kiet.lateinitlazy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSum.setOnClickListener {
            if (binding.txtNum1.text.isNotEmpty() && binding.txtNum2.text.isNotEmpty()) {
               // var cal =Calculation()
                  Calculation.num1=binding.txtNum1.text.toString().toInt()
                Calculation.num2=binding.txtNum2.text.toString().toInt()
                Toast.makeText(
                    applicationContext,
                    "Sum ="+Calculation.getSum(),
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(
                    applicationContext,
                    "Please enter numbers",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.btnMul.setOnClickListener {
            if (binding.txtNum1.text.isNotEmpty() && binding.txtNum2.text.isNotEmpty()) {
                var cal =Calculation()
                var multiply=cal.getMul(binding.txtNum1.text.toString().toInt(),binding.txtNum2.text.toString().toInt())
                Toast.makeText(
                    applicationContext,
                    "Multiply ="+multiply,
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(
                    applicationContext,
                    "Please enter numbers",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}




