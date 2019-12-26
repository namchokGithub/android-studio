package com.example.flagmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

class second : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup? ,savedInstanceState: Bundle?): View? {

        super.onCreate(savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val bundle = arguments
        if (bundle != null) {
            msg = bundle.getString("msg").toString()

        }

        val button : Button = view.findViewById(R.id.btnNextPage);

        button.setOnClickListener {

            Toast.makeText(context,"Change to fragment 3 Success", Toast.LENGTH_LONG).show()

            val fragment_third = third()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_third,"fragment_third")
            transaction.addToBackStack("fragment_third")
            transaction.commit()

        }

        val text : TextView = view.findViewById(R.id.text)
        text.setText(msg)

        return view

    }

    private var msg : String = ""

    fun newInstance(message: String): second {

        val fragment = second()
        val bundle = Bundle()
        bundle.putString("msg", message)
        fragment.setArguments(bundle)

        return fragment
    }

}
