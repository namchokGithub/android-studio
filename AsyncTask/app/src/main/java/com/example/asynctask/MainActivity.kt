package com.example.asynctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ShowData = ShowData()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.layout, ShowData,"fragment_ShowData")
        transaction.addToBackStack("fragment_ShowData")
        transaction.commit()

    }

}
