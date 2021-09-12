package edu.kiet.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import edu.kiet.retrofitexample.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user=UserInstance.userInterface.userInfor()
        user.enqueue(object:Callback<UserInfo>{
            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                val userInfo:UserInfo?=response.body()
                if(userInfo!=null)
                {
                    val adapter=Adapter(this@MainActivity,userInfo)
                    binding.recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                    binding.recyclerView.adapter=adapter
                }
            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Toast.makeText(applicationContext,t.toString(),Toast.LENGTH_SHORT).show()
            }
        })
    }
}