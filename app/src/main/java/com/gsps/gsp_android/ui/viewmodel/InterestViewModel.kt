package com.gsps.gsp_android.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InterestViewModel : ViewModel(){
    private var count =0
    val countText :MutableLiveData<String> = MutableLiveData()

    fun init(){
        countText.value ="($count/5)"
    }
    fun clickButton(){
        countText.value = "(${count++}/5)"
    }

    override fun onCleared() {
        super.onCleared()
    }

}