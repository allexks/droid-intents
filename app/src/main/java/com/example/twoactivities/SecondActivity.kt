package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    companion object {
        val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    }

    private lateinit var mReply: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView = findViewById<TextView>(R.id.text_message)
        mReply = findViewById(R.id.editText_second)

        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        textView.text = message
    }

    fun returnReply(view: View) {
        val reply = mReply.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(Activity.RESULT_OK, replyIntent)
        finish()
    }
}
