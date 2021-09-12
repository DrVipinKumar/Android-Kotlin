package edu.kiet.imageexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class ImageSlider : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var viewPager: ViewPager
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_slider)
        viewPager=findViewById(R.id.viewPager)
        val imageAdapter =ImageAdapter(this@ImageSlider)
        viewPager.adapter=imageAdapter

    }
}