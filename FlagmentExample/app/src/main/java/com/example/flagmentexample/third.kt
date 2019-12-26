package com.example.flagmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

class third : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup? ,savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        val view = inflater.inflate(
            R.layout.fragment_third,
            container,
            false
        )

        val button : Button = view.findViewById(R.id.btnNextPage1);

        button.setOnClickListener {

            Toast.makeText(context,"Change to fragment 1 Success", Toast.LENGTH_LONG).show()

            val fragment_first = first()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_first,"fragment_first")
            transaction.addToBackStack("fragment_first")
            transaction.commit()

        }

        return view

    }

}
