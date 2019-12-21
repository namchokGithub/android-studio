package com.example.smartdevice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity(){

    private lateinit var username : EditText
    private lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // No title
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {}

        setContentView(R.layout.activity_main)
    }

    fun login(view: View) {

        val intent = Intent(this, Home::class.java)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        val usernameText  = username.text.toString()
        val passwordText  = password.text.toString()

        intent.putExtra("username", usernameText)
        intent.putExtra("password", passwordText)

        startActivity(intent)
    }


}
