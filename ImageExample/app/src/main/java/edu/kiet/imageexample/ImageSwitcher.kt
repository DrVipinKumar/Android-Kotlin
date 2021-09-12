package edu.kiet.imageexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.Toast

class ImageSwitcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_switcher)
        var imageView:ImageView
        var previous: Button
        var next:Button
        var i:Int=0
        imageView=findViewById(R.id.imageView)
        previous=findViewById(R.id.btnPrevious)
        next=findViewById(R.id.btnNext)
        var images= arrayListOf<Int>(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5)
        previous.setOnClickListener(View.OnClickListener {
            if(i>0)
            {
                i--
                imageView.setImageResource(images[i])
            }
            else
            {
                Toast.makeText(applicationContext,"First Image",Toast.LENGTH_SHORT).show()
                i=0
            }
        })
        next.setOnClickListener(View.OnClickListener {
            if(i<4)
            {
                i++
                imageView.setImageResource(images[i])
            }
            else
            {
                Toast.makeText(applicationContext,"Last Image",Toast.LENGTH_SHORT).show()
                i=4
            }
        })
    }
}