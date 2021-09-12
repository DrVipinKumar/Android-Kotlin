package edu.kiet.realtimedatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import edu.kiet.realtimedatabaseexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val database = Firebase.database
    val myRef = database.getReference("Students")
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener(View.OnClickListener {
            if(!binding.txtStudentName.text.isEmpty() && !binding.txtCourse.text.isEmpty()&&
                !binding.txtBranch.text.isEmpty() && !binding.txtTotalMarks.text.isEmpty()) {
                val sname = binding.txtStudentName.text.toString()
                val scourse = binding.txtCourse.text.toString()
                val sbranch = binding.txtBranch.text.toString()
                val smarks = binding.txtTotalMarks.text.toString()
                val updateData=mapOf<String,String>(
                    "name" to sname,
                    "course" to scourse,
                    "branch" to sbranch,
                    "marks" to smarks.toString()
                )
                myRef.child(sname).updateChildren(updateData).addOnSuccessListener {
                    binding.txtStudentName.text.clear()
                    binding.txtCourse.text.clear()
                    binding.txtBranch.text.clear()
                    binding.txtTotalMarks.text.clear()
                    Toast.makeText(applicationContext,"Student information updated",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(applicationContext,"Student information not updated",Toast.LENGTH_SHORT).show()
                }


            }else
            {
                Toast.makeText(applicationContext,"Pleaes insert information",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnDelete.setOnClickListener(View.OnClickListener {
            if(!binding.txtStudentName.text.isEmpty()) {
                val sname = binding.txtStudentName.text.toString()
                myRef.child(sname).removeValue().addOnSuccessListener {
                    Toast.makeText(applicationContext,"Student information deleted",Toast.LENGTH_SHORT).show()
                }
                    .addOnFailureListener{
                         Toast.makeText(applicationContext,"Student not found",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                Toast.makeText(applicationContext,"Please write student name",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnRead.setOnClickListener(View.OnClickListener {
            if(!binding.txtStudentName.text.isEmpty()) {
                val sname = binding.txtStudentName.text.toString()
                myRef.child(sname).get().addOnSuccessListener {
                    val data =StringBuffer()
                    if(it.exists())
                    {
                        data.append("Student Name="+it.child("name").value+"\n")
                        data.append("Student Course="+it.child("course").value+"\n")
                        data.append("Student Branch="+it.child("branch").value+"\n")
                        data.append("Student Marks="+it.child("marks").value+"\n")
                        displayMessage("Student Information",data.toString())
                    }
                }.addOnFailureListener{
                    Toast.makeText(applicationContext,"Student not found",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                Toast.makeText(applicationContext,"Please write student name",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnAdd.setOnClickListener(View.OnClickListener {
            if(!binding.txtStudentName.text.isEmpty() && !binding.txtCourse.text.isEmpty()&&
                !binding.txtBranch.text.isEmpty() && !binding.txtTotalMarks.text.isEmpty()) {
                val sname = binding.txtStudentName.text.toString()
                val scourse = binding.txtCourse.text.toString()
                val sbranch = binding.txtBranch.text.toString()
                val smarks = binding.txtTotalMarks.text.toString()
                val studentData=StudentInfo(sname,scourse,sbranch,smarks.toString().toInt())
                myRef.child(sname).setValue(studentData).addOnSuccessListener {
                    binding.txtStudentName.text.clear()
                    binding.txtCourse.text.clear()
                    binding.txtBranch.text.clear()
                    binding.txtTotalMarks.text.clear()
                    Toast.makeText(applicationContext,"Record Inserted",Toast.LENGTH_SHORT).show()
                }
                    .addOnFailureListener{
                        Toast.makeText(applicationContext,"Record not Inserted",Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(applicationContext,"Please insert information",Toast.LENGTH_SHORT).show()
            }
        })

    }
    fun displayMessage(title:String, msg:String)
    {
        val builder=AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(msg)
        builder.setCancelable(true)
        builder.show()
    }
}