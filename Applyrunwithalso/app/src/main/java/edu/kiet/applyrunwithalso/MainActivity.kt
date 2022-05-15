package edu.kiet.applyrunwithalso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.kiet.applyrunwithalso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSum.setOnClickListener {
            if (binding.txtNum1.text.isNotEmpty() && binding.txtNum2.text.isNotEmpty())
            {
                var numbers=Values().apply {
                    num1=binding.txtNum1.text.toString().toInt()
                    num2=binding.txtNum2.text.toString().toInt()
                    Toast.makeText(applicationContext,"Sum=${num1+num2}",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                Toast.makeText(applicationContext,"Please insert value",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnSub.setOnClickListener {
            if (binding.txtNum1.text.isNotEmpty() && binding.txtNum2.text.isNotEmpty())
            {
                var numbers=Values().also {
                    it.num1=binding.txtNum1.text.toString().toInt()
                    it.num2=binding.txtNum2.text.toString().toInt()
                    Toast.makeText(applicationContext,"Subtraction=${it.num1-it.num2}",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                Toast.makeText(applicationContext,"Please insert value",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnDiv.setOnClickListener {
            if (binding.txtNum1.text.isNotEmpty() && binding.txtNum2.text.isNotEmpty())
            {
                var numbers=Values().run {
                    num1=binding.txtNum1.text.toString().toInt()
                    num2=binding.txtNum2.text.toString().toInt()
                    num1/num2

                }
                Toast.makeText(applicationContext,"Division=${numbers}",Toast.LENGTH_SHORT).show()
            }else
            {
                Toast.makeText(applicationContext,"Please insert value",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnMul.setOnClickListener {
            if (binding.txtNum1.text.isNotEmpty() && binding.txtNum2.text.isNotEmpty())
            {
//                var numbers=Values().let {
//                    it.num1=binding.txtNum1.text.toString().toInt()
//                    it.num2=binding.txtNum2.text.toString().toInt()
//                   Toast.makeText(applicationContext,"Multiply=${ it.num1*it.num2}",Toast.LENGTH_SHORT).show()
//                }
                var numbers=Values()
                    with(numbers) {
                    num1=binding.txtNum1.text.toString().toInt()
                    num2=binding.txtNum2.text.toString().toInt()
                    Toast.makeText(applicationContext,"Multiply=${ num1*num2}",Toast.LENGTH_SHORT).show()
                }

            }else
            {
                Toast.makeText(applicationContext,"Please insert value",Toast.LENGTH_SHORT).show()
            }
        }
    }
}

class Values {
    var num1:Int=0
    var num2:Int=0
}
