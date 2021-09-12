package edu.kiet.cameraex

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import edu.kiet.cameraex.databinding.ActivityVideoCaptureBinding

class VideoCapture : AppCompatActivity() {
    lateinit var videobinding:ActivityVideoCaptureBinding
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        videobinding= ActivityVideoCaptureBinding.inflate(layoutInflater)
        setContentView(videobinding.root)
        videobinding.btnVideo.setOnClickListener(View.OnClickListener {
            var intent =Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            activityResultLauncher.launch(intent)
        })
        activityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult? ->
            if(result!!.resultCode==Activity.RESULT_OK)
            {
                val videouri=result!!.data!!.data
                videobinding.videoView.setVideoURI(videouri)
                videobinding.videoView.setMediaController(MediaController(this))
                videobinding.videoView.requestFocus()
                videobinding.videoView.start()
            }
            else
            {
                Toast.makeText(applicationContext,"Video is not captured",Toast.LENGTH_SHORT).show()
            }
        }
    }
}