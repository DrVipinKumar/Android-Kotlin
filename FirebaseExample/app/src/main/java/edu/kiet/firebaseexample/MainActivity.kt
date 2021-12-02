package edu.kiet.firebaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import edu.kiet.firebaseexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener(View.OnClickListener {
            if(binding.txtStudentName.text.isNotEmpty()&&binding.txtRoll.text.isNotEmpty()
                &&binding.txtCourse.text.isNotEmpty()&&binding.txtBranch.text.isNotEmpty()) {
                val student = hashMapOf(
                    "sname" to binding.txtStudentName.text.toString(),
                    "sroll" to binding.txtRoll.text.toString().toInt(),
                    "scourse" to binding.txtCourse.text.toString(),
                    "sbranch" to binding.txtBranch.text.toString()
                )

                val query=db.collection("Students")
                    .whereEqualTo("sroll",binding.txtRoll.text.toString().toInt())
                    .get()
                query.addOnSuccessListener {
                    for(document in it)
                    {
                        db.collection("Students").document(document.id).set(student, SetOptions.merge())
                    }
                    Toast.makeText(applicationContext,"Information Updated",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                Toast.makeText(applicationContext,"Please insert value first",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnDelete.setOnClickListener(View.OnClickListener {
            if(binding.txtRoll.text.isNotEmpty())
            {
                val query=db.collection("Students")
                    .whereEqualTo("sroll",binding.txtRoll.text.toString().toInt())
                    .get()
                query.addOnSuccessListener {
                    for(document in it)
                    {
                        db.collection("Students").document(document.id).delete().addOnSuccessListener {
                            Toast.makeText(applicationContext,"Student Information Deleted",Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }else{
                Toast.makeText(applicationContext,"Insert Roll to Delete",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnRead.setOnClickListener(View.OnClickListener {
            val data=StringBuffer()
            db.collection("Students")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        data.append("Document ID="+document.id+"\n")
                        data.append("Student Name="+document.get("sname")+"\n")
                        data.append("Student Roll="+document.get("sroll")+"\n")
                        data.append("Student Course="+document.get("scourse")+"\n")
                        data.append("Student Branch="+document.get("sbranch")+"\n\n")
                        data.append("=================================\n")
                    }
                    displayMessage("Student Information",data.toString())
                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext,"Error:"+e.toString(),Toast.LENGTH_SHORT).show()
                }
        })
        binding.btnAdd.setOnClickListener(View.OnClickListener {
            if(binding.txtStudentName.text.isNotEmpty()&&binding.txtRoll.text.isNotEmpty()
                &&binding.txtCourse.text.isNotEmpty()&&binding.txtBranch.text.isNotEmpty()) {
                val student = hashMapOf(
                    "sname" to binding.txtStudentName.text.toString(),
                    "sroll" to binding.txtRoll.text.toString().toInt(),
                    "scourse" to binding.txtCourse.text.toString(),
                    "sbranch" to binding.txtBranch.text.toString()
                )

// Add a new document with a generated ID
                db.collection("Students")
                    .add(student)
                    .addOnSuccessListener { documentReference ->
                        Toast.makeText(applicationContext,"Record Insert with ID: ${documentReference.id}",Toast.LENGTH_SHORT).show()

                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(applicationContext,"Error:"+e.toString(),Toast.LENGTH_SHORT).show()
                    }
            }else
            {
                Toast.makeText(applicationContext,"Please insert value first",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun displayMessage(title: String,data: String) {
        val builder =AlertDialog.Builder(this@MainActivity)
        builder.setTitle(title)
        builder.setMessage(data)
        builder.setCancelable(true)
        builder.show()
    }
}