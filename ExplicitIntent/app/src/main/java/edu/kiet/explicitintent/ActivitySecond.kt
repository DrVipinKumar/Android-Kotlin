package edu.kiet.explicitintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ActivitySecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var txtData=findViewById<TextView>(R.id.txtData)
        var txtreply=findViewById<EditText>(R.id.txtReply)
        var btnReply=findViewById<Button>(R.id.btnReply)
        txtData.text=intent.extras!!.getString("info")
        btnReply.setOnClickListener(View.OnClickListener {
            var intent=Intent()
            intent.putExtra("reply",txtreply.text.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()
        })

    }
}