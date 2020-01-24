package com.example.team


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

/**
 * A simple [Fragment] subclass.
 */
class login : Fragment() {

    lateinit var UsernameInput: EditText
    lateinit var PasswordInput: EditText
    lateinit var btnLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        UsernameInput = view.findViewById(R.id.UsernameInput)
        PasswordInput = view.findViewById(R.id.PasswordInput)

        btnLogin = view.findViewById(R.id.btnLogin)
        btnLogin!!.setOnClickListener{
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
            val fmHome = home()

            val mg = fragmentManager
            mg!!.beginTransaction().replace(R.id.main_layout, fmHome, "Fragemnt_Home").addToBackStack("Fragemnt_Home").commit()

        }
}
