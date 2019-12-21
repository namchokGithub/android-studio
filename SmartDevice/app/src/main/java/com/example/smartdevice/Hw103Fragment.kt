package com.example.smartdevice


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

/**
 * A simple [Fragment] subclass.
 */
class Hw103Fragment : Fragment() {

    private lateinit var btnHw04 : Button
    private lateinit var btnHw02 : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_hw103, container, false)

        btnHw02 = v.findViewById(R.id.backHw1021)
        btnHw02.setOnClickListener {
            hw02()
        }

        btnHw04 = v.findViewById(R.id.nextHw1041)
        btnHw04.setOnClickListener {
            hw04()
        }

        return inflater.inflate(R.layout.fragment_hw103, container, false)
    }

    fun hw04() {
        val fragment = Hw104Fragment()
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_hw101, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }
    fun hw02() {
        val fragment = Hw102Fragment()
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_hw101, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }


}
