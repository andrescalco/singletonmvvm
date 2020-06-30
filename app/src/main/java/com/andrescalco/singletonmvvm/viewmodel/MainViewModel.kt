package com.andrescalco.singletonmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.andrescalco.singletonmvvm.model.User
import com.andrescalco.singletonmvvm.repository.Repository

class MainViewModel : ViewModel(){
    private val _userId: MutableLiveData<String> = MutableLiveData()
    var user: LiveData<User> = Transformations
        .switchMap(_userId){userId ->
            Repository.getUser(userId)
        }

    fun setUserId(userId: String){
        val update = userId
        if(_userId.value == update){
            return
        }
        _userId.value = update
    }

    fun cancelJobs(){
        Repository.cancelJobs()
    }
}