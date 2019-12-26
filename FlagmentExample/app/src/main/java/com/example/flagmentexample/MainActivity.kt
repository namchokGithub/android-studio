package com.example.flagmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment_first = first()
        val manager = supportFragmentManager;
        val transaction = manager.beginTransaction();

        transaction.replace(R.id.contentContainer, fragment_first, "flagment_first")
        transaction.addToBackStack("flagment_first")
        transaction.commit()

        val fragment_fourth = fourth()
        supportFragmentManager.beginTransaction().replace(R.id.contentContainerBelow, fragment_fourth, "fragment_fourth").addToBackStack("fragment_fourth").commit()
    }

    override fun onBackPressed() {

        val manager = supportFragmentManager.findFragmentById(R.id.contentContainer)

        if (manager is third ) {

            finish()

        }
        else{
            super.onBackPressed();
        }

    }
}
