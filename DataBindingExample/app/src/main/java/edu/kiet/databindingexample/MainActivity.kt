package edu.kiet.databindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import edu.kiet.databindingexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        val infoViewProvider=ViewModelProvider(this).get(InfoViewModel::class.java)
        binding.infoData=infoViewProvider
        binding.lifecycleOwner=this
        val myImage=MyImage("https://mcdn.wallpapersafari.com/medium/52/29/VDx5Xb.jpg")
        binding.myImage=myImage



    }
}