package com.example.andersenlab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

import android.widget.EditText




class FirstActivity : AppCompatActivity() {

    companion object {
        val LOG_TAG: String = FirstActivity::class.java.simpleName
        const val EXTRA_MESSAGE = "com.example.andersenlab2.extra.MESSAGE"
        const val TEXT_REQUEST = 1
    }

    private lateinit var mMessageEditText: EditText

    private lateinit var mReplyHeadTextView: TextView

    private lateinit var mReplyTextView: TextView

    private lateinit var mButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)
        mButton = findViewById(R.id.button_main)

        mButton.setOnClickListener {
            Log.d(LOG_TAG, "Button clicked!")

            val intent = Intent(this,SecondActivity::class.java)
            val message = mMessageEditText.text.toString()
            intent.putExtra(EXTRA_MESSAGE, message)
            startActivityForResult(intent, TEXT_REQUEST)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == TEXT_REQUEST) {
            if(resultCode == RESULT_OK) {
                val reply = data?.extras?.get(SecondActivity.EXTRA_REPLY)
                mReplyHeadTextView.visibility = View.VISIBLE

                mReplyTextView.text = reply.toString()
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }
}