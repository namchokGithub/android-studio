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

        // Load fragment background
        val fmLogin = login()
        supportFragmentManager.beginTransaction().replace(R.id.contentFrame, fmLogin, "fmLogin").addToBackStack("fmLogin").commit()

        // Load fragment input login
        val fmInput = loginInput()
        supportFragmentManager.beginTransaction().replace(R.id.inputLogin, fmInput, "Input login").commit()
        
    }

    /*
     * Name: onBackPressed
     * Description: When back press
     * Input: None
     * Output: None
     * */
    override fun onBackPressed() {

        val contentFrame = supportFragmentManager.findFragmentById(R.id.contentFrame)
        val inputLogin = supportFragmentManager.findFragmentById(R.id.inputLogin)

        if (contentFrame is login ) {   // this contentFrame is login fragment
            finish()
        }
        else{
            if(inputLogin is BlankFragment) {  // Check if input layout is blank fragment
                val loginInput = loginInput()
                supportFragmentManager.beginTransaction().replace(R.id.inputLogin, loginInput, "Input login").commit()
            }
            super.onBackPressed()
        }

    }
}
