package edu.kiet.toastex


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var showButton =findViewById<Button>(R.id.btnShowToast) as Button
        var showAlertDialog =findViewById<Button>(R.id.btnAlertDialog)
        val showCustomAlertDialog =findViewById<Button>(R.id.btnCustomAlertDialog)
         showCustomAlertDialog.setOnClickListener(View.OnClickListener {
             var layout=layoutInflater.inflate(R.layout.customtoast,null)
             var alertDialog = AlertDialog.Builder(this@MainActivity)
             alertDialog.setTitle("Custom Alert")
             alertDialog.setView(layout)
             alertDialog.setCancelable(true)
             alertDialog.show()
         })
        showAlertDialog.setOnClickListener(View.OnClickListener {
            var alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setTitle("Simple Alert")
            alertDialog.setMessage("This is very simple alert dialog box")
            alertDialog.setCancelable(true)
            alertDialog.show()
        })
        showButton.setOnClickListener(View.OnClickListener {
            var toast=Toast.makeText(applicationContext,"This is Android Toast for Showing Information",Toast.LENGTH_SHORT)
             toast.show()
        })
    }
}