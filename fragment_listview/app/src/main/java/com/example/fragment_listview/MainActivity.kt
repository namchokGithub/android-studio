package com.example.fragment_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {



    val fragment_first = fragment_login()
    val manager = supportFragmentManager;
    val transaction = manager.beginTransaction();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment_RecyclerView = fragment_recycler_view()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.layout, fragment_first,"fragment_RecyclerView")
        transaction.addToBackStack("fragment_list_view")
        transaction.commit()

    }


}
