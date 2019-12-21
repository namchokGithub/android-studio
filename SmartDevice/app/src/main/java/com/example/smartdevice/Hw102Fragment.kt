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
class Hw102Fragment : Fragment() {

    private lateinit var btnHw01 : Button
    private lateinit var btnHw03 : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_work, container, false)

        btnHw01 = v.findViewById(R.id.backHw01)
        btnHw01.setOnClickListener {
            hw01()
        }

        btnHw03 = v.findViewById(R.id.nextHw03)
        btnHw03.setOnClickListener {
            hw03()
        }

        return inflater.inflate(R.layout.fragment_hw102, container, false)
    }

    fun hw01() {
        val fragment = Hw101Fragment()
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }
    fun hw03() {
        val fragment = Hw103Fragment()
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }

}
