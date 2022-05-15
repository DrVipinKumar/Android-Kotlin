package edu.kiet.statevssharedflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import edu.kiet.statevssharedflow.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel =ViewModelProvider(this).get(MainViewModel::class.java)
        binding.btnStateFlow.setOnClickListener {
            viewModel.updateStateFlow(binding.txtSharedStateValue.text.toString())
        }
        binding.btnSharedData.setOnClickListener {
            viewModel.updateSharedFlow(binding.txtSharedStateValue.text.toString())
        }
        lifecycleScope.launchWhenStarted {
            viewModel.sharedFlow.collectLatest {
                binding.txtSharedData.text=it
                Snackbar.make(binding.root,it,Snackbar.LENGTH_SHORT).show()
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.stateFlow.collectLatest {
                binding.txtStateFlow.text=it
                Toast.makeText(applicationContext,it,Toast.LENGTH_SHORT).show()
            }
        }

    }
}