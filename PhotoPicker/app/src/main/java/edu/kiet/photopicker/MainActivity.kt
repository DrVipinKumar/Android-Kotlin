package edu.kiet.photopicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import edu.kiet.photopicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_PICK_IMAGE)
            startActivityForResult(intent, PHOTO_PICKER_REQUEST_CODE)
        }
    }
}