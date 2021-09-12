package edu.kiet.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import edu.kiet.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding:ActivityMainBinding= ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        val data:ArrayList<String> = arrayListOf<String>("C Programming", "C++ Programming","Java Programming","Kotlin Programming","Python Programming");
        var adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        binding.listview.adapter=adapter;
        binding.listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,adapter.getItem(position),Toast.LENGTH_SHORT).show();
        }
    }
}