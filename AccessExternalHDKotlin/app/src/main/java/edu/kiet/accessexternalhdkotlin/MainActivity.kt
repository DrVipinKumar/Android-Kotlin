package edu.kiet.accessexternalhdkotlin

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import edu.kiet.accessexternalhdkotlin.databinding.ActivityMainBinding
import java.io.*

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnWriteToFile.setOnClickListener(View.OnClickListener {
            try {
                val file=File(getExternalFilesDir("android11file"),binding.txtFileName.text.toString())
                val fileWrite=BufferedWriter(FileOutputStream(file).bufferedWriter())
                fileWrite.write(binding.txtFileData.text.toString())
                fileWrite.close()
                Toast.makeText(applicationContext,"File created",Toast.LENGTH_SHORT).show()
            }catch (error:FileNotFoundException)
            {
                Toast.makeText(applicationContext,"File not found",Toast.LENGTH_SHORT).show()
            }

        })
        binding.btnReadFromFile.setOnClickListener(View.OnClickListener {
            try {
                val file=File(getExternalFilesDir("android11file"),binding.txtFileName.text.toString())
                val fileRead=BufferedReader(FileInputStream(file).bufferedReader())
                val data=StringBuffer()
                var line=fileRead.readLine()
                while(line!=null)
                {
                    data.append(line)
                    line=fileRead.readLine()
                }
                Toast.makeText(applicationContext,data.toString(),Toast.LENGTH_SHORT).show()
            }catch (error:FileNotFoundException)
            {
                Toast.makeText(applicationContext,"File not found",Toast.LENGTH_SHORT).show()
            }
        })

    }

}