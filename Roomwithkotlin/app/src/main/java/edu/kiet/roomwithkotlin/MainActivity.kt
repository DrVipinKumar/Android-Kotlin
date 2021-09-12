package edu.kiet.roomwithkotlin

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import edu.kiet.roomwithkotlin.databinding.ActivityMainBinding
import edu.kiet.roomwithkotlin.roomdata.User
import edu.kiet.roomwithkotlin.roomdata.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener(View.OnClickListener {

            val userId:EditText= EditText(this@MainActivity)
            val builder=AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Enter user id to update")
            builder.setView(userId)
            builder.setPositiveButton("Update User Info",object:DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    val uid:Int=userId.text.toString().toInt()

                    if(!binding.txtName.text.isEmpty() && !binding.txtPhone.text.isEmpty())
                    {
                        val userInfo= User(uid,binding.txtName.text.toString(),binding.txtPhone.text.toString())
                        GlobalScope.launch(Dispatchers.IO) {
                            UserDatabase.getInstance(this@MainActivity).userDao().update(userInfo)
                        }
                        displayInfo("User Info","Record Updated")
                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Please insert value first",Toast.LENGTH_SHORT).show()
                    }

                }

            })
            builder.create()
            builder.show()

        })
        binding.btnDelete.setOnClickListener(View.OnClickListener {
            val userId:EditText= EditText(this@MainActivity)
            val builder=AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Enter user id to delete")
            builder.setView(userId)
            builder.setPositiveButton("Delete User",object:DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    val uid:Int=userId.text.toString().toInt()
                    GlobalScope.launch(Dispatchers.IO) {
                        UserDatabase.getInstance(this@MainActivity).userDao().delete(uid)

                    }
                    displayInfo("User Info","Record Deleted")
                }

            })
            builder.create()
            builder.show()

        })
        binding.btnDisplay.setOnClickListener(View.OnClickListener {
           lateinit var allUser:List<User>
            val userData:StringBuffer= StringBuffer()
           GlobalScope.launch(Dispatchers.IO) {
                allUser = UserDatabase.getInstance(this@MainActivity).userDao().display()
               launch(Dispatchers.Main) {
                   allUser.forEach{it->
                       userData.append("UserID="+it.uid+" UserName="+it.userName+" User Phone="+it.userPhone+"\n")
                   }
                   displayInfo("User Information",userData.toString())
               }
            }

        })
        binding.btnInsert.setOnClickListener(View.OnClickListener {
            if(!binding.txtName.text.isEmpty() && !binding.txtPhone.text.isEmpty())
            {
                val userInfo= User(null,binding.txtName.text.toString(),binding.txtPhone.text.toString())
                GlobalScope.launch(Dispatchers.IO) {
                    UserDatabase.getInstance(this@MainActivity).userDao().insert(userInfo)
                }
                Toast.makeText(applicationContext,"Record inserted",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(applicationContext,"Please insert value first",Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun displayInfo(title:String,userData: String) {
        val builder=AlertDialog.Builder(this@MainActivity)
        builder.setTitle(title)
        builder.setMessage(userData)
        builder.setCancelable(true)
        builder.show()
    }
}