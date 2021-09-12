package edu.kiet.firebaseauthentication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import edu.kiet.firebaseauthentication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.btnRegister.setOnClickListener(View.OnClickListener {
            if(!binding.txtEmail.text.isEmpty() && !binding.txtPassword.text.isEmpty()) {
                val email=binding.txtEmail.text.toString()
                val password=binding.txtPassword.text.toString()
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                           if(auth.currentUser!=null)
                               {
                                   startHomeActivity()
                               }

                        } else {

                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                    }
            }
            else
            {
                Toast.makeText(applicationContext,"Kindly write email and password",Toast.LENGTH_SHORT).show()
            }

        })
        binding.btnLogin.setOnClickListener(View.OnClickListener {
            if (!binding.txtEmail.text.isEmpty() && !binding.txtPassword.text.isEmpty()) {
                val email = binding.txtEmail.text.toString()
                val password = binding.txtPassword.text.toString()
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            if(auth.currentUser!=null)
                            {
                                startHomeActivity()
                            }

                        } else {

                            Toast.makeText(
                                baseContext, "Login failed.",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                    }

            } else {
                Toast.makeText(
                    applicationContext,
                    "Kindly write email and password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            startHomeActivity()
        }
    }

    private fun startHomeActivity() {
        val intent = Intent(this@MainActivity,HomePage::class.java)
        startActivity(intent)
    }

}