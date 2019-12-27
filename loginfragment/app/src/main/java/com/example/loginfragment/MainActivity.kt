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
        supportFragmentManager.beginTransaction().replace(R.id.inputLogin, fmInput, "Input login").commit()


    }

    override fun onBackPressed() {

        val contentFrame = supportFragmentManager.findFragmentById(R.id.contentFrame)
        val inputLogin = supportFragmentManager.findFragmentById(R.id.inputLogin)

        if (contentFrame is login ) {

            finish()

        }
        else{
            if(inputLogin is BlankFragment) {
                val loginInput = loginInput()
                supportFragmentManager.beginTransaction().replace(R.id.inputLogin, loginInput, "Input login").commit()
            }
            super.onBackPressed();
        }

    }
}
