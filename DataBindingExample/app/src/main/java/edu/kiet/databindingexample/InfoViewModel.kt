package edu.kiet.databindingexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfoViewModel: ViewModel() {
    var info= MutableLiveData("This is info by LiveData")
}