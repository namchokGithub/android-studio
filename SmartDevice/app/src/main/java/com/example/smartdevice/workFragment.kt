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
class workFragment : Fragment() {

    private lateinit var btnHw01 : Button
    private lateinit var btnHw02 : Button
    private lateinit var btnHw03 : Button
    private lateinit var btnHw04 : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_work, container, false)

        btnHw01 = v.findViewById(R.id.menuHw101)
        btnHw01.setOnClickListener {
            hw01()
        }

        btnHw02 = v.findViewById(R.id.menuHw102)
        btnHw02.setOnClickListener {
            hw02()
        }


        btnHw03 = v.findViewById(R.id.menuHw103)
        btnHw03.setOnClickListener {
            hw03()
        }


        btnHw04 = v.findViewById(R.id.menuHw104)
        btnHw04.setOnClickListener {
            hw04()
        }

        return v
    }

    fun hw01() {
        val fragment = Hw101Fragment()
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }
    fun hw02() {
        val fragment = Hw102Fragment()
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
    fun hw04() {
        val fragment = Hw104Fragment()
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }



}
