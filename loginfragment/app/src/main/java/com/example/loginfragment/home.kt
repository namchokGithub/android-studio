package com.example.loginfragment


import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class home : Fragment() {
    private lateinit var usernameData: String
    private lateinit var passwordData: String
    private lateinit var textHi: TextView
    private lateinit var textPassword: TextView
    private lateinit var textUsername: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        textHi = view.findViewById(R.id.hi)
        this.textPassword = view.findViewById(R.id.textPassword)
        this.textUsername = view.findViewById(R.id.textUsername)

        val bundle = arguments
        if (bundle != null) {
            usernameData = bundle.getString("usernameK").toString()
            passwordData = bundle.getString("passwordK").toString()
            this.textPassword.text = passwordData
            this.textUsername.text = usernameData
        }else {
            this.textPassword.text = "Testuser"
            this.textUsername.text = "Testpass"
        }

        return view
    }

    private fun loadData(){
        this.textPassword.text = passwordData
        this.textUsername.text = usernameData
    }

    fun sendData(username: String, password: String): home {
        val fragment = home()
        val bundle = Bundle()
        bundle.putString("usernameK", username)
        bundle.putString("passwordK", password)
        fragment.setArguments(bundle)

        return fragment
    }
}
