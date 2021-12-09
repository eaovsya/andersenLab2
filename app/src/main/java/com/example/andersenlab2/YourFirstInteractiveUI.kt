package com.example.andersenlab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class YourFirstInteractiveUI : AppCompatActivity() {

    private lateinit var countUpButton: Button
    private lateinit var showToastButton: Button
    private lateinit var mShowCount: TextView
    private var mCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_first_interactive_ui)
        countUpButton = findViewById(R.id.button_count)
        showToastButton = findViewById(R.id.button_toast)
        mShowCount = findViewById(R.id.show_count)

        countUpButton.setOnClickListener {
            countUp()
        }

        showToastButton.setOnClickListener {
            showToast()
        }
    }

    private fun showToast() {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    private fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
    }
}