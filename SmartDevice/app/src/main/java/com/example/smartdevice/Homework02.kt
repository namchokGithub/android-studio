package com.example.smartdevice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent

class Homework02 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // No title
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {}
        setContentView(R.layout.activity_homework02)
    }

    fun hw03(view: View) {
        val intent = Intent(this, Homework03::class.java)
        startActivity(intent)
    }

    fun hw01(view: View) {
        val intent = Intent(this, Homework01::class.java)
        startActivity(intent)
    }
}
