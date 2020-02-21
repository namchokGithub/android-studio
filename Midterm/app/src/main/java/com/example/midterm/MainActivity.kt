package com.example.midterm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        setContentView(R.layout.activity_main)


        val login = login()
        supportFragmentManager.beginTransaction().replace(R.id.layout, login, "login").addToBackStack("login").commit()


    }

    override fun onBackPressed() {

        val contentFrame = supportFragmentManager.findFragmentById(R.id.layout)

        if (contentFrame is list || contentFrame is login) {   // this contentFrame is login fragment
            finish()
        }
        else{

            super.onBackPressed()
        }

    }
}
