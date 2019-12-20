package com.example.smartdevice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Homework03 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // No title
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {}
        setContentView(R.layout.activity_homework03)
    }

    fun hw04(view: View) {
        val intent = Intent(this, Homework04::class.java)
        startActivity(intent)
    }

    fun hw02(view: View) {
        val intent = Intent(this, Homework02::class.java)
        startActivity(intent)
    }
}
