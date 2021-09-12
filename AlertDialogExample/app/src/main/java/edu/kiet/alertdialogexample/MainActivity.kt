package edu.kiet.alertdialogexample

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import edu.kiet.alertdialogexample.databinding.ActivityMainBinding

lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var choice =arrayOf("Java","Kotlin","Python","JavaScript","NodeJS")
        var selectchoice= booleanArrayOf(true, true, false, false, false)
        binding.btnAlertButton.setOnClickListener(View.OnClickListener {
            var alertDialog =AlertDialog.Builder(this@MainActivity)
            alertDialog.setTitle("Alert Buttons")
            alertDialog.setMessage("This is alert for Yes|NO|Cancel Button")
            alertDialog.setPositiveButton("Yes"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(applicationContext,"You selected YES",Toast.LENGTH_SHORT).show()
            }
            alertDialog.setNegativeButton("NO"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(applicationContext,"You selected NO",Toast.LENGTH_SHORT).show()
            }
            alertDialog.setNeutralButton("Cancel"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(applicationContext,"You selected Cancel",Toast.LENGTH_SHORT).show()
            }
            alertDialog.setCancelable(true)
            alertDialog.show()
        })
        binding.btnShowAlertCheckbox.setOnClickListener(View.OnClickListener {
            var alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setTitle("Alert CheckBox Information")
            alertDialog.setMultiChoiceItems(choice,selectchoice){ dialogInterface: DialogInterface, postion: Int, check: Boolean ->
                if(check==true) {
                    Toast.makeText(
                        applicationContext,
                        "You selected =" + choice[postion],
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else
                {
                    Toast.makeText(
                        applicationContext,
                        "You un-selected =" + choice[postion],
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            alertDialog.setCancelable(true)
            alertDialog.show()
        })
        binding.btnShowAlertRadio.setOnClickListener(View.OnClickListener {
            var alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setTitle("Alert Radio Information")
            alertDialog.setSingleChoiceItems(choice,0){ dialogInterface: DialogInterface, postion: Int ->
                Toast.makeText(applicationContext,"You selected ="+choice[postion],Toast.LENGTH_SHORT).show()
            }

            alertDialog.setCancelable(true)
            alertDialog.show()
        })
        binding.btnAlertList.setOnClickListener(View.OnClickListener {
            var alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setTitle("Alert Information")
            alertDialog.setItems(choice){ dialogInterface: DialogInterface, postion: Int ->
                Toast.makeText(applicationContext,"You selected ="+choice[postion],Toast.LENGTH_SHORT).show()
            }
            alertDialog.setCancelable(true)
            alertDialog.show()
        })

        binding.btnShowAlert.setOnClickListener(View.OnClickListener {
            var alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setTitle("Alert Information")
            alertDialog.setMessage("This is example of Simple Alert Dialog Box");
            alertDialog.setCancelable(true)
            alertDialog.show()
            showMessage("Error","This is Error message")

        })
        binding.btnMessageDialog.setOnClickListener(View.OnClickListener {
            showMessage("Info","This is message dialog box")
        })
        binding.btnCustomDialog.setOnClickListener(View.OnClickListener {
           var viewalert= layoutInflater.inflate(R.layout.customalert,null)
            var alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setView(viewalert)
            alertDialog.setCancelable(true)
            alertDialog.show()
        })

    }

    private fun showMessage(title: String, msg: String) {
        var alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle(title)
        alertDialog.setMessage(msg);
        alertDialog.setCancelable(true)
        alertDialog.show()
    }


}