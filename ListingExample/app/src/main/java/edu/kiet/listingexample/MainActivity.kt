package edu.kiet.listingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import edu.kiet.listingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var images= arrayOf(R.drawable.blub,R.drawable.bookmark,R.drawable.cup,R.drawable.monitor,R.drawable.mouse,
                            R.drawable.music,R.drawable.flag,R.drawable.person,R.drawable.printer)
        var listing= arrayListOf<String>("Blub","Bookmark","Cup","Monitor","Mouse","Music","Flag","Person","Printer")
       // var adapter=ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_list_item_1,listing)
        var adapter=MyAdapter(this@MainActivity,images,listing)
        binding.recyclerview.layoutManager=GridLayoutManager(this@MainActivity,2)
        binding.recyclerview.adapter=adapter;

    }
}