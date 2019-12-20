package com.example.smartdevice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Home : AppCompatActivity() {

    private lateinit var  username : TextView
    private lateinit var  password : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // No title
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {}

        setContentView(R.layout.activity_home)

        personShow()
    }

    private fun personShow(){
        username = findViewById(R.id.textUsername)
        password = findViewById(R.id.textPassword)

        val usernameText = intent.extras!!.getString("username")
        val passwordText = intent.extras!!.getString("password")

        if(usernameText != ""){
            username.text = usernameText.toString()

            // Toast
            val message = "Hi! " + usernameText.toString()
            val myToast = Toast.makeText(applicationContext, message,Toast.LENGTH_SHORT)
            myToast.show()
        }else {
            username.text = "NO DATA"
        }

        if(passwordText != ""){
            password.text = passwordText.toString()
        }else {
            password.text = "NO DATA"
        }


    }

    public fun go(view: View) {
        val intent = Intent(this, Homework01::class.java)
        startActivity(intent)
    }
}


