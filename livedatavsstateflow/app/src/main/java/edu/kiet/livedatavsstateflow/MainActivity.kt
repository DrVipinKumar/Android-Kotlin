package edu.kiet.livedatavsstateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import edu.kiet.livedatavsstateflow.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel =ViewModelProvider(this).get(MainViewModel::class.java)
        binding.btnLiveData.setOnClickListener {
            viewModel.updateLiveData(binding.txtLiveStateValue.text.toString())
        }
        binding.btnStateFlow.setOnClickListener {
            viewModel.updateStateFlow(binding.txtLiveStateValue.text.toString())
        }
        viewModel.liveData.observe(this){
            binding.txtLiveData.text=it
           Snackbar.make(binding.root,it,Snackbar.LENGTH_LONG).show()
        }
        lifecycleScope.launchWhenStarted {
            viewModel.stateFlow.collectLatest {
                binding.txtStateFlow.text=it
               //Snackbar.make(binding.root,it,Snackbar.LENGTH_LONG).show()
            }
        }

    }
}