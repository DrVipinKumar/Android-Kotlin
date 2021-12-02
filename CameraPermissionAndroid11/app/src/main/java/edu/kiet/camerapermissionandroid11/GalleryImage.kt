package edu.kiet.camerapermissionandroid11

import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import edu.kiet.camerapermissionandroid11.databinding.ActivityGalleryImageBinding



class GalleryImage : AppCompatActivity() {
    val url:String="https://mcdn.wallpapersafari.com/medium/52/29/VDx5Xb.jpg"
    lateinit var binding:ActivityGalleryImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_gallery_image)
        val imageUrl=ImageUrl(url)
        binding.imageUrl=imageUrl
        binding.lifecycleOwner=this
        val imageGallery=registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                binding.imageView.setImageURI(it)
                            })
        binding.btnLoadImage.setOnClickListener(View.OnClickListener {
            imageGallery.launch("image/*")
        })
    }
}