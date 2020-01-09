package com.example.loginfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class loginInput : Fragment() {

    private lateinit var inputUsername: EditText
    private lateinit var inputPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_login_input, container, false)

        inputUsername = view.findViewById(R.id.inputUsername)
        inputPassword = view.findViewById(R.id.inputPassword)

        val btn_login = view.findViewById<Button>(R.id.btnLogin)
        btn_login!!.setOnClickListener{
            this.loadPageHome()
        }

        return view
    }

    /*
     * Name: loadPageHome
     * Description: load home fragment to show username and password
     * Input: None
     * Output: None
     * */
    private fun loadPageHome(){
        val fmHome = home().sendData(inputUsername.text.toString(), inputPassword.text.toString())
        val empty = BlankFragment()

        val mg = fragmentManager
        mg!!.beginTransaction().replace(R.id.contentFrame, fmHome, "Fragemnt_Home").addToBackStack("Fragemnt_Home").commit()

        val mg2 = fragmentManager
        mg2!!.beginTransaction().replace(R.id.inputLogin, empty, "empty").commit()
    }

}
