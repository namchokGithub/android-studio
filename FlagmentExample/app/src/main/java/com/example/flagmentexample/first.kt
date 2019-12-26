package com.example.flagmentexample

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

class first : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_first, container, false)

        val button : Button = view.findViewById(R.id.btnNextPage2);

        button.setOnClickListener {

            Toast.makeText(context,"Change to fragment 2 Success", Toast.LENGTH_LONG).show()

            val fragment_second =second()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_second,"fragment_second")
            transaction.addToBackStack("fragment_second")
            transaction.commit()

        }

        return view;
    }

}
