package edu.kiet.livedatavsstateflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {
    private val _liveData=MutableLiveData<String>("Live Data Info")
    val liveData=_liveData as LiveData<String>
    fun updateLiveData(value:String){
        _liveData.value=value
    }
    private  val _stateFlow = MutableStateFlow("State Flow Info")
    val stateFlow=_stateFlow as StateFlow<String>
    fun updateStateFlow(value:String){
        _stateFlow.value=value
    }
}