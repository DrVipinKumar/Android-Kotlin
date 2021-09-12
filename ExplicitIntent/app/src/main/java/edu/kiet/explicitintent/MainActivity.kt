package edu.kiet.explicitintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      var btnSendData=findViewById<Button>(R.id.btnOpenSecondActivity)
        var info=findViewById<EditText>(R.id.txtDisplay)
        btnSendData.setOnClickListener(View.OnClickListener {
            var intent=Intent(this@MainActivity,ActivitySecond::class.java)
            intent.putExtra("info",info.text.toString())
            activityResultLauncher.launch(intent)
        })
        activityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult? ->
            if(result!!.resultCode== Activity.RESULT_OK)
            {
                if(result.data!!.extras!!.getString("reply").toString().equals("Yes"))
                    Toast.makeText(applicationContext,"Congratulation!!",Toast.LENGTH_SHORT).show()
                else
                {
                    Toast.makeText(applicationContext,"Sorry!!",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}