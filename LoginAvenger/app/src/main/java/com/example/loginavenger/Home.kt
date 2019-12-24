package com.example.loginavenger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*


class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {}

        text1!!.text = this.intent.extras!!.getString("username")
        text2!!.text = this.intent.extras!!.getString("password")

    }
}
