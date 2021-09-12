package edu.kiet.volleyexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import edu.kiet.volleyexample.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val apiUrl="https://api.github.com/users"
    lateinit var userInfo:UserInfo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val stringRequest=StringRequest(apiUrl,Response.Listener {
            val gsonBuilder=GsonBuilder()
            val gson = gsonBuilder.create()
            userInfo=gson.fromJson(it,UserInfo::class.java)
            //userInfoItem.forEach {
              //  userInfo.add(it)
           // }
            val adapter =Adapter(this,userInfo)
            binding.recyclerView.layoutManager=LinearLayoutManager(this)
            binding.recyclerView.adapter=adapter

        }, Response.ErrorListener {
            Toast.makeText(applicationContext,it.toString(),Toast.LENGTH_SHORT).show()
        })
        val volleyQueue =Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)

    }
}