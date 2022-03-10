package com.example.lifecycleaware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleaware.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModelFactory: MainViewModelFactory
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModelFactory = MainViewModelFactory(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        mainViewModel.count.observe(this, Observer {
            binding.textView.text = it.toString()
            Log.i("MainActivity", "$it")
        })

        lifecycle.addObserver(mainViewModel)

        buttonPress()
    }

    private fun buttonPress() {
        binding.button.setOnClickListener {
            if (Lifecycle.State.STARTED.isAtLeast(Lifecycle.State.STARTED)) {
                Toast.makeText(applicationContext, "plus 1", Toast.LENGTH_SHORT).show()
                mainViewModel.countUp()
            }
        }
    }
}