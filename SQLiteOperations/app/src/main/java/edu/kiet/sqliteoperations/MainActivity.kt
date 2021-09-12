package edu.kiet.sqliteoperations

import android.app.AlertDialog
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import edu.kiet.sqliteoperations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dbcon:MyDBConnection= MyDBConnection(this@MainActivity,"LoginDBInfo",1)
        binding.btnUpdate.setOnClickListener(View.OnClickListener {
            if(!binding.txtName.text.isEmpty() && !binding.txtPassword.text.isEmpty()) {
                val result= dbcon.update(binding.txtName.text.toString(),binding.txtPassword.text.toString())
                if(result.equals(-1))
                {
                    Toast.makeText(applicationContext,"Record not updated",Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(applicationContext,"Record updated",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                Toast.makeText(applicationContext,"Please insert values first",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnDelete.setOnClickListener(View.OnClickListener {
            if(!binding.txtName.text.isEmpty()) {
                val result=dbcon.delete(binding.txtName.text.toString())
                if(result.equals(-1))
                {
                    Toast.makeText(applicationContext,"Record not found",Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(applicationContext,"Record deleted",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                Toast.makeText(applicationContext,"Write username first",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnDisply.setOnClickListener(View.OnClickListener {
            val cursor=dbcon.display()
            val data:StringBuffer= StringBuffer()
            var count:Int=0
            if(cursor.count>0)
            {
                while(cursor.moveToNext())
                {
                    count=count+1
                    data.append(count.toString()+". UserName="+cursor.getString(1)+" , Password="+cursor.getString(2)+"\n")
                }
                displayRecord("Record Information",data.toString())
            }
            else
            {
                Toast.makeText(applicationContext,"Record are not available",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnInsert.setOnClickListener(View.OnClickListener {
            if(!binding.txtName.text.isEmpty() && !binding.txtPassword.text.isEmpty()) {
               val result= dbcon.insert(binding.txtName.text.toString(),binding.txtPassword.text.toString())
                if(result.equals(-1))
                {
                    Toast.makeText(applicationContext,"Record not inserted",Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(applicationContext,"Record inserted",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                Toast.makeText(applicationContext,"Please insert values first",Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun displayRecord(title:String, data:String)
    {
        val builder=AlertDialog.Builder(this@MainActivity)
        builder.setTitle(title)
        builder.setMessage(data)
        builder.show()
    }

}