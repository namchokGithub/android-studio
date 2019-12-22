package com.example.smartdevice


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
class Hw104Fragment : Fragment() {
    private lateinit var btnHw03 : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_hw104, container, false)

        btnHw03 = v.findViewById(R.id.backHw1031)
        btnHw03.setOnClickListener {
            hw03()
            val myToast = Toast.makeText(activity, "Test", Toast.LENGTH_SHORT)
            myToast.show()
        }

        return v
    }

    fun hw03() {
        val fragment = Hw103Fragment()
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_hw101, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }

}
