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
class Hw101Fragment : Fragment() {

    private lateinit var btnHw02 : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if(container == null){
            return null
        }
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_hw101, container, false)

        btnHw02 = v.findViewById(R.id.nextHw1021)
        btnHw02.setOnClickListener {
            hw02()
        }

        return v
    }

    fun hw02(){
        val fragment = Hw102Fragment()
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_hw101, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }

}
