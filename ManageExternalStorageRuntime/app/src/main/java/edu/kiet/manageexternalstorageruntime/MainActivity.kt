package edu.kiet.manageexternalstorageruntime

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import edu.kiet.manageexternalstorageruntime.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var launchRequest: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnWriteData.setOnClickListener(){
            if (checkPermission())
            {
                if (binding.txtFileName.text.isNotEmpty()) {
                    var file = File(
                        Environment.getExternalStoragePublicDirectory("Download"),binding.txtFileName.text.toString())
                    file.createNewFile()
                    file.bufferedWriter().use { out->out.write(binding.txtData.text.toString()) }
                    Snackbar.make(binding.root,"Data is written in file"+binding.txtFileName.text.toString(),Snackbar.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(applicationContext,"Write file name",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                requestPermission()
            }
        }
        binding.btnReadData.setOnClickListener(){
            if (checkPermission())
            {
                if (binding.txtFileName.text.isNotEmpty()) {
                    var file = File(
                        Environment.getExternalStoragePublicDirectory("Download"),binding.txtFileName.text.toString())
                        binding.txtData.setText(file.readText())
                }
                else
                {
                    Toast.makeText(applicationContext,"Write file name",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                requestPermission()
            }
        }
        launchRequest=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult ->
                               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                                        if (Environment.isExternalStorageManager())
                                        {
                                            Toast.makeText(applicationContext,"Permission Granted",Toast.LENGTH_SHORT).show()
                                        }
                                   else
                                        {
                                            Toast.makeText(applicationContext,"Permission Granted",Toast.LENGTH_SHORT).show()
                                        }
                                   }

        }


    }
    private fun checkPermission():Boolean{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (Environment.isExternalStorageManager())
                {
                    return true
                }
            }
        return false
    }
    private fun requestPermission() {
        var intent =Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
        intent.addCategory("android.intent.category.DEFAULT")
        intent.setData(Uri.parse(String.format("package:%s",applicationContext.packageName)))
        launchRequest.launch(intent)
    }
}