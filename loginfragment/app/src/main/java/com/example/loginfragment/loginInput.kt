package com.example.loginfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_login_input.*

/**
 * A simple [Fragment] subclass.
 */
class loginInput : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_login_input, container, false)

        val btn_login = view.findViewById<Button>(R.id.btnLogin)
        btn_login!!.setOnClickListener{
            loadPageHome()
        }

        return view
    }

    fun loadPageHome(){
        val fmHome = home()
        fmHome.sendData(inputUsername.text.toString(), inputUsername.text.toString())
        val mg = fragmentManager
        mg!!.beginTransaction().replace(R.id.contentFrame, fmHome, "Fragemnt_Home").addToBackStack("Fragemnt_Home").commit()
    }


}
