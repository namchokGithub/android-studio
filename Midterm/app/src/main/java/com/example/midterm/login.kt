package com.example.midterm


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

/**
 * A simple [Fragment] subclass.
 */
class login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val userInput = view.findViewById<EditText>(R.id.inputUser)
        val passInput = view.findViewById<EditText>(R.id.inputPass)
        val btn_login = view.findViewById<Button>(R.id.login)

        btn_login!!.setOnClickListener{

            if(userInput.text.toString().isEmpty() && passInput.text.toString().isEmpty()){
                Toast.makeText(activity,"Please enter Username or Password", Toast.LENGTH_SHORT).show()
            }else if(userInput.text.toString() == "60160169" && passInput.text.toString() == "60160169"){
                val list = list()
                val manager = fragmentManager
                manager!!.beginTransaction().replace(R.id.layout, list, "list").addToBackStack("list").commit()
            }else if(userInput.text.toString().isEmpty()){
                Toast.makeText(activity,"Please Enter Your Username!!", Toast.LENGTH_SHORT).show()
            }else if(passInput.text.toString().isEmpty()){
                Toast.makeText(activity,"Please Enter Your Password!!", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(activity,"Incorrect Username or Password", Toast.LENGTH_SHORT).show()
            }



        }

        return view
    }


}
