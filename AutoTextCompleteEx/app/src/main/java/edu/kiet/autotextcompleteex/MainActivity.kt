package edu.kiet.autotextcompleteex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import edu.kiet.autotextcompleteex.databinding.ActivityMainBinding

lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var data= arrayListOf<String>("Windows OS","Linux OS","Android OS","MAC OS","Other OS")
        var adapter=ArrayAdapter<String>(applicationContext,android.R.layout.simple_list_item_1,data)
        binding.autoText.setAdapter(adapter)
        binding.multiAutoText.setAdapter(adapter)
        binding.multiAutoText.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }
}