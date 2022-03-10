package com.example.lifecycleaware

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleaware.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var mainViewModelFactory: MainViewModelFactory
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mainViewModelFactory = MainViewModelFactory(requireActivity())
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        binding = FragmentMainBinding.inflate(inflater, container, false)

        mainViewModel.count.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it.toString()
        })

        lifecycle.addObserver(mainViewModel)

        clickButton()

        return binding.root
    }

    private fun clickButton() {
        binding.button.setOnClickListener {
            mainViewModel.countUp()
        }
    }
}