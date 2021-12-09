package com.example.andersenlab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ActivityLifeCycleState : AppCompatActivity() {
    companion object {
        val LOG_TAG: String = ActivityLifeCycleState::class.java.simpleName
        const val EXTRA_MESSAGE = "com.example.andersenlab2.extra.MESSAGE"
        const val TEXT_REQUEST = 1
    }

    private lateinit var mMessageEditText: EditText

    private lateinit var mReplyHeadTextView: TextView

    private lateinit var mReplyTextView: TextView

    private lateinit var mButton: Button

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(mReplyHeadTextView.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", mReplyTextView.text.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_state)

        mMessageEditText = findViewById(R.id.editText_main_lifecycle)
        mReplyHeadTextView = findViewById(R.id.text_header_reply_lifecycle)
        mReplyTextView = findViewById(R.id.text_message_reply_lifecycle)
        mButton = findViewById(R.id.button_main_lifecycle)

        mButton.setOnClickListener {
            Log.d(LOG_TAG, "Button clicked!")

            val intent = Intent(this, ActivityLifecCycleStateSecond::class.java)
            val message = mMessageEditText.text.toString()
            intent.putExtra(EXTRA_MESSAGE, message)
            startActivityForResult(intent, TEXT_REQUEST)

        }

        if(savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if(isVisible) {
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = savedInstanceState.getString("reply_text")
                mReplyTextView.visibility = View.VISIBLE
            }
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