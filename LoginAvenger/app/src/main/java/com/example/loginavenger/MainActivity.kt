package com.example.loginavenger

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        login?.setOnClickListener{
            val intent = Intent(this, Home::class.java)

            intent.putExtra("username", username.text.toString())
            intent.putExtra("password", username.text.toString())

            startActivity(intent)
        }
    }
}
