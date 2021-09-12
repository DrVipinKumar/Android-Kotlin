package edu.kiet.recyclerviewwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import edu.kiet.recyclerviewwithkotlin.databinding.ActivityMainBinding

private lateinit var binding:ActivityMainBinding;
private lateinit var radapter:RecyclerAdapter;
var imageName=ArrayList<Int>();
var imageTitle=ArrayList<String>();
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageName.add(R.drawable.blub);
        imageName.add(R.drawable.bookmark);
        imageName.add(R.drawable.cup);
        imageName.add(R.drawable.flag);
        imageName.add(R.drawable.monitor);
        imageName.add(R.drawable.mouse);
        imageName.add(R.drawable.music);
        imageName.add(R.drawable.person);
        imageName.add(R.drawable.printer);
        imageTitle.add("Blub");
        imageTitle.add("BookMark");
        imageTitle.add("Cup");
        imageTitle.add("Flag");
        imageTitle.add("Monitor");
        imageTitle.add("Mouse");
        imageTitle.add("Music");
        imageTitle.add("Person");
        imageTitle.add("Printer");

        binding= ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
        radapter=RecyclerAdapter(applicationContext,imageName, imageTitle);
        val gridLayout=GridLayoutManager(applicationContext,2);
        binding.recyclerView.layoutManager=gridLayout;
        binding.recyclerView.adapter=radapter;

    }
}