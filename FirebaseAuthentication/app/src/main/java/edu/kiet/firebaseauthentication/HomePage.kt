package edu.kiet.firebaseauthentication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import edu.kiet.firebaseauthentication.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    lateinit var binding:ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogout.setOnClickListener(View.OnClickListener {
            Firebase.auth.signOut()
            val intent= Intent(this@HomePage,MainActivity::class.java)
            startActivity(intent)
        })
    }
}