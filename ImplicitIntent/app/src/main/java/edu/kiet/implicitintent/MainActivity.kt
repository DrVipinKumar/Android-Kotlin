package edu.kiet.implicitintent

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import edu.kiet.implicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShowMap.setOnClickListener(View.OnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("geo:28.704060,77.102493"))
            var intentchooser=Intent.createChooser(intent,"Show Delhi Map")
            startActivity(intentchooser)
        })
        binding.btnCall.setOnClickListener(View.OnClickListener {
            var mobileno=binding.txtMobileNo.text
            var intent =Intent(Intent.ACTION_CALL)
            intent.setData(Uri.parse("tel:"+mobileno))
            if(ActivityCompat.checkSelfPermission(this@MainActivity,android.Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this@MainActivity, arrayOf(android.Manifest.permission.CALL_PHONE),1)
            }
            else
            {
                startActivity(intent)
            }

        })

    }
}