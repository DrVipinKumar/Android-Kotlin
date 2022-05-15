package edu.kiet.datastoreexample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import edu.kiet.datastoreexample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val dataStore: DataStore<Preferences> by preferencesDataStore(name = "login")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener {
            if (binding.txtName.text.isNotEmpty() && binding.txtPassword.text.isNotEmpty())
            {
                GlobalScope.launch(Dispatchers.Main) {
                    saveLoginInfo(binding.txtName.text.toString(),binding.txtPassword.text.toString())
                    Toast.makeText(applicationContext,"User registered",Toast.LENGTH_SHORT).show()
                }


            }else
            {
                Toast.makeText(applicationContext,"Please insert username and password",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnLogin.setOnClickListener {
            if (binding.txtName.text.isNotEmpty() && binding.txtPassword.text.isNotEmpty())
            {
                GlobalScope.launch(Dispatchers.Main) {
                    val pass=readLoginInfo(binding.txtName.text.toString())
                    if (pass.equals("teotia"))
                    {
                        val intent =Intent(applicationContext,Welcome::class.java)
                        startActivity(intent)
                    }else {
                        Toast.makeText(applicationContext, "Username or password in wrong", Toast.LENGTH_SHORT)
                            .show()
                    }
                }


            }else
            {
                Toast.makeText(applicationContext,"Please insert username and password",Toast.LENGTH_SHORT).show()
            }
        }

    }
    suspend fun readLoginInfo(key:String):String{
        val loginkey= stringPreferencesKey(key)
        val preferences=dataStore.data.first()
        return preferences[loginkey].toString()
    }
suspend fun saveLoginInfo(key:String, value:String){
    val loginkey= stringPreferencesKey(key)
    dataStore.edit { login ->
       login[loginkey] = value
    }
}
}