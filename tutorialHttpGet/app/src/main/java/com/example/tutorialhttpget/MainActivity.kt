package com.example.tutorialhttpget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ส่วนของการเรียก Fragment ของ Recycler view
        val fragmentRecyclerview = Recycler_view()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.layout, fragmentRecyclerview,"fragment_RecyclerView")
        transaction.addToBackStack("fragment_RecyclerView")
        transaction.commit()


    }
}
