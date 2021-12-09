package com.example.andersenlab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ImplicitIntentReceiver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent_receiver)

        val uri = intent.data
        if(uri != null) {
            val uri_string = getString(R.string.uri_label) + uri.toString()

            val textView = findViewById<TextView>(R.id.text_uri_message)
            textView.text = uri_string
        }
    }
}