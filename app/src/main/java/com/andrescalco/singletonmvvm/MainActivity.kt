package com.andrescalco.singletonmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.andrescalco.singletonmvvm.databinding.ActivityMainBinding
import com.andrescalco.singletonmvvm.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.setUserId("1")

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }
}