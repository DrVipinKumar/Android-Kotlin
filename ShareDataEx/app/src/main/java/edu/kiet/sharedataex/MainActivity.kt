package edu.kiet.sharedataex

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import edu.kiet.sharedataex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGoogleplus.setOnClickListener(View.OnClickListener {
            if(checkPackage("com.google.android.apps.plus"))
            {
                val intent= Intent(Intent.ACTION_SEND)
                intent.type="text/plain"
                val data:String="This is my data to send"
                intent.putExtra(Intent.EXTRA_TEXT,data)
                intent.`package`="com.google.android.apps.plus"
                startActivity(intent)
            }
            else
            {
                Toast.makeText(applicationContext,"Google+ not installed",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnWhatsapp.setOnClickListener(View.OnClickListener {
            if(checkPackage("com.whatsapp"))
            {
                val intent= Intent(Intent.ACTION_SEND)
                intent.type="text/plain"
                val data:String="This is my data to send"
                intent.putExtra(Intent.EXTRA_TEXT,data)
                intent.`package`="com.whatsapp"
                startActivity(intent)
            }
            else
            {
                Toast.makeText(applicationContext,"WhatsApp not installed",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnTwitter.setOnClickListener(View.OnClickListener {
            if(checkPackage("com.twitter.android"))
            {
                val intent= Intent(Intent.ACTION_SEND)
                intent.type="text/plain"
                val data:String="This is my data to send"
                intent.putExtra(Intent.EXTRA_TEXT,data)
                intent.`package`="com.twitter.android"
                startActivity(intent)
            }
            else
            {
                Toast.makeText(applicationContext,"Twitter not installed",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnFacebook.setOnClickListener(View.OnClickListener {
            if(checkPackage("com.facebook.katana"))
            {
                val intent= Intent(Intent.ACTION_SEND)
                intent.type="text/plain"
                val data:String="This is my data to send"
                intent.putExtra(Intent.EXTRA_TEXT,data)
                intent.`package`="com.facebook.katana"
                startActivity(intent)
            }
            else
            {
                Toast.makeText(applicationContext,"Facebook not installed",Toast.LENGTH_SHORT).show()
            }
        })

    }
    fun checkPackage( packagename:String):Boolean
    {
        val pm=applicationContext.packageManager
        try {
            pm.getPackageInfo(packagename,PackageManager.GET_META_DATA)
        }catch (exp:PackageManager.NameNotFoundException)
        {
            return false
        }
        return true
    }

}