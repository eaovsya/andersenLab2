package com.example.andersenlab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.app.ShareCompat


class ImplicitIntents : AppCompatActivity() {

    private lateinit var mWebsiteEditText: EditText
    private lateinit var mLocationEditText: EditText
    private lateinit var mShareTextEditText: EditText
    private lateinit var mWebsiteEditTextButton: Button
    private lateinit var mLocationEditTextButton: Button
    private lateinit var mShareTextEditTextButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)

        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareTextEditText = findViewById(R.id.share_edittext)

        mWebsiteEditTextButton = findViewById(R.id.open_website_button)
        mLocationEditTextButton = findViewById(R.id.open_location_button)
        mShareTextEditTextButton = findViewById(R.id.share_text_button)

        mWebsiteEditText.setOnClickListener {
            openWebsite(it)
        }

        mLocationEditText.setOnClickListener {
            openLocation(it)
        }

        mShareTextEditText.setOnClickListener {
            shareText(it)
        }
    }

    private fun openWebsite(view: View?) {
        val url = mWebsiteEditText.text.toString()

        val webpage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this!")
        }
    }

    private fun openLocation(view: View?) {
        val loc = mLocationEditText.text.toString()

        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    private fun shareText(view: View?) {
        val txt = mShareTextEditText.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(R.string.share_text_with)
            .setText(txt)
            .startChooser()
    }

}