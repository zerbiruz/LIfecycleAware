package com.example.lifecycleaware

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*

class MainViewModel(private val context: Context) : ViewModel(), DefaultLifecycleObserver {

    private val TAG = "MyObserver"

    private var _count: MutableLiveData<Int> = MutableLiveData(0)
    val count: LiveData<Int>
        get() = _count

    fun countUp() {
        _count.value = _count.value?.plus(1)
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.i(TAG, "onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.i(TAG, "onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Toast.makeText(context, "Retrieving data ...", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.i(TAG, "onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        _count.value = _count?.value?.plus(1)
        Toast.makeText(context, "Preparing to exit ...", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.i(TAG, "onDestroy")
    }
}