package com.example.flagmentexample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

/**
 * A simple [Fragment] subclass.
 */
class fourth : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =inflater.inflate(R.layout.fragment_fourth, container, false)

        val button : Button = view.findViewById(R.id.btnNextPageF2);

        button.setOnClickListener {

            Toast.makeText(context,"Change to fragment below 2 Success", Toast.LENGTH_LONG).show()

            val fragment_second =second()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainerBelow, fragment_second,"fragment_second")
            transaction.addToBackStack("fragment_second")
            transaction.commit()

        }

        return view
    }



}
