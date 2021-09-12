package edu.kiet.sendemail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import edu.kiet.sendemail.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSend.setOnClickListener(View.OnClickListener {
            if(!binding.txtTo.text.isEmpty() && !binding.txtMessage.text.isEmpty() && !binding.txtSubject.text.isEmpty())
            {
                var intent=Intent(Intent.ACTION_SEND)
                intent.data=Uri.parse("Email")
                intent.putExtra(Intent.EXTRA_EMAIL,arrayOf(binding.txtTo.text))
                intent.putExtra(Intent.EXTRA_SUBJECT,binding.txtSubject.text)
                intent.putExtra(Intent.EXTRA_TEXT,binding.txtMessage.text)
                intent.type="message/rfc822"
                var chooser=Intent.createChooser(intent,"Send Email")
                startActivity(chooser)

            }
            else
            {
                Toast.makeText(applicationContext,"Fill complete information",Toast.LENGTH_SHORT).show()
            }
        })


    }
}