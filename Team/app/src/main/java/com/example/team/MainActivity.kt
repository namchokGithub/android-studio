package com.example.team

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        // Load fragment background
        val fmLogin = login()
        supportFragmentManager.beginTransaction().replace(R.id.main_layout, fmLogin, "fmLogin").addToBackStack("fmLogin").commit()
    }
}
