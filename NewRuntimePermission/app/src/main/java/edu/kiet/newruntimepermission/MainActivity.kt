package edu.kiet.newruntimepermission

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import edu.kiet.newruntimepermission.databinding.ActivityMainBinding
import java.io.*
import java.lang.StringBuilder
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var resultlauncher:ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resultlauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result:ActivityResult->

            if (result.resultCode== Activity.RESULT_OK) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if(Environment.isExternalStorageManager())
                    {
                        Snackbar.make(binding.root, "Permission Granted", Snackbar.LENGTH_SHORT).show()
                    }
                    else
                    {
                        Snackbar.make(binding.root, "Permission not Granted", Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
        }
        binding.btnReadData.setOnClickListener(){
            var data: StringBuilder? =null
            var line :String?=""
                if (checkPermission())
                {
                    var file=File(Environment.getExternalStoragePublicDirectory("Download"),binding.txtFileNmme.text.toString())
                    binding.txtFileData.setText(file.readText())

                }else
                {
                    requestPermission()
                }
        }
        binding.btnWriteData.setOnClickListener(){
            if (checkPermission())
            {
                var file=File(Environment.getExternalStoragePublicDirectory("Download"),binding.txtFileNmme.text.toString())
                file.createNewFile()
                file.bufferedWriter().use { out->out.write(binding.txtFileData.text.toString())}
                Snackbar.make(binding.root,"Data written in file "+binding.txtFileNmme.text.toString(),
                Snackbar.LENGTH_SHORT).show()
            }else
            {
                requestPermission()
            }
        }
    }
    fun checkPermission():Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (Environment.isExternalStorageManager()) {
                return true
            }
            }
        return false
    }


    fun requestPermission(){

        //Manage External Storage Permission Runtime in Android 11 or above using kotlin
        //Manage External Storage Permission in Android 11 for reading or writing file
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            var intent= Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
            intent.addCategory("android.intent.category.DEFAULT")
            intent.setData(Uri.parse(String.format("package:%s",applicationContext.packageName)))
            resultlauncher.launch(intent)
        }
    }

}