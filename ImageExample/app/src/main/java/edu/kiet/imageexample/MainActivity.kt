package edu.kiet.imageexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var changeImage: Button;
        var imageview:ImageView;
        imageview=findViewById(R.id.imageView) as ImageView
        changeImage =findViewById(R.id.btnChangeImage)as Button
        changeImage.setOnClickListener(View.OnClickListener {
            imageview.setImageResource(R.drawable.image3)
        })

    }
}