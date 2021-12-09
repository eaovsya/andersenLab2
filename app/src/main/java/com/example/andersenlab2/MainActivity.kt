package com.example.andersenlab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var androidStudioHelloWorldButton: Button
    private lateinit var yourFirstInteractiveUIButton: Button
    private lateinit var theLayoutEditorButton: Button
    private lateinit var theLayoutEditorButtonRelative: Button
    private lateinit var textAndScrollingViews: Button
    private lateinit var twoActivitiesButton: Button
    private lateinit var activityLifeCycleStateButton: Button
    private lateinit var implicitIntentsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        androidStudioHelloWorldButton = findViewById(R.id.android_studio_hello_world_button)
        setClickListener(androidStudioHelloWorldButton, AndroidStudioHelloWorld::class.java)

        yourFirstInteractiveUIButton = findViewById(R.id.your_first_interactive_ui)
        setClickListener(yourFirstInteractiveUIButton, YourFirstInteractiveUI::class.java)

        theLayoutEditorButton = findViewById(R.id.the_layout_editor)
        setClickListener(theLayoutEditorButton, TheLayoutEditorLinearLayout::class.java)

        theLayoutEditorButtonRelative = findViewById(R.id.the_layout_editor_relative)
        setClickListener(theLayoutEditorButtonRelative, TheEditLayoutRelative::class.java)

        textAndScrollingViews = findViewById(R.id.text_and_scrolling_views_button)
        setClickListener(textAndScrollingViews, TextAndScrollingViews::class.java)

        twoActivitiesButton = findViewById(R.id.two_activities_button)
        setClickListener(twoActivitiesButton, FirstActivity::class.java)

        activityLifeCycleStateButton = findViewById(R.id.activity_lifecycle_state_button)
        setClickListener(activityLifeCycleStateButton, ActivityLifeCycleState::class.java)

        implicitIntentsButton = findViewById(R.id.implicit_intents_button)
        setClickListener(implicitIntentsButton, ImplicitIntents::class.java)

    }

    private fun setClickListener(button: Button, activity: Class<*>) {
        button.setOnClickListener {
            startActivity(Intent(this, activity))
        }
    }
}