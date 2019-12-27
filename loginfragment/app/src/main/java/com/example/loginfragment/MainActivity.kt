package com.example.loginfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_login_input.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        val fmLogin = login()
        supportFragmentManager.beginTransaction().replace(R.id.contentFrame, fmLogin, "fmLogin").addToBackStack("fmLogin").commit()

        val fmInput = loginInput()
        supportFragmentManager.beginTransaction().replace(R.id.inputLogin, fmInput, "Input login").addToBackStack("Input login").commit()


    }

    override fun onBackPressed() {

        val manager = supportFragmentManager.findFragmentById(R.id.contentFrame)

        if (manager is login ) {

            finish()

        }
        else{
            super.onBackPressed();
        }

    }
}
