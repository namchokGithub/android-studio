package com.example.smartdevice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent

class Homework01 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // No title
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {}
        setContentView(R.layout.activity_homework01)
    }

    fun hw02(view: View) {
        val intent = Intent(this, Homework02::class.java)
        startActivity(intent)
    }

    fun logout(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
