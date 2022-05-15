package edu.kiet.flowvslivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import edu.kiet.flowvslivedata.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel =ViewModelProvider(this).get(MainViewModel::class.java)
        binding.btnChangeLiveData.setOnClickListener {
            viewModel.updateLiveData(binding.txtChangeValue.text.toString())
        }
        binding.btnChangeFlow.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                viewModel.getFlowInfo().collectLatest {
                    binding.txtFlowData.text=it
                }
            }
        }
        viewModel.liveData.observe(this){
            binding.txtLiveData.text=it
        }
    }
}