package com.example.lifecycleaware

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class MyObserver(private val context: Context, private val lifecycle: Lifecycle) : DefaultLifecycleObserver {

    private val TAG = "MyObserver"

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
        Toast.makeText(context, "Preparing to exit ...", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.i(TAG, "onDestroy")
    }
}