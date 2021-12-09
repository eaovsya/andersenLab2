package com.example.andersenlab2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.IOException

class AndroidStudioHelloWorld : AppCompatActivity() {

    private val TAG: String = AndroidStudioHelloWorld::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_studio_hello_world)
        Log.d(TAG, "Happy Birthday to Brendan Fraser")
        try {
            throw IOException("IOException was thrown")
        } catch (e: IOException) {
            val msg = e.localizedMessage ?: ""
            Log.e(TAG, msg)
        }
    }
}