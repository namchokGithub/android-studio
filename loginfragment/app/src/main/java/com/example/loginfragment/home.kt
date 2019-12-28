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

        // find view ID from TextView in fragment_home
        this.textPassword = view.findViewById(R.id.textPassword)
        this.textUsername = view.findViewById(R.id.textUsername)

        val bundle = arguments;
        if (bundle != null) {              // If arguments have some data
            usernameData = bundle.getString("usernameK").toString()
            passwordData = bundle.getString("passwordK").toString()
            loadData()                     // Load data to TextView
        }else {                            // Else no data from arguments
            this.textPassword.text = "Test user"
            this.textUsername.text = "Test pass"
        }

        return view
    }

    /*
     * Name : loadData
     * Description : Set data from to TextView
     * Input : None
     * Output : None
     * */
    private fun loadData(){
        this.textPassword.text = passwordData
        this.textUsername.text = usernameData
    }

    /*
     * Name : sendData
     * Description : Send data from some to fragment to another fragment
     * Input : Username and Password
     * Output : this fragment
     * */
    fun sendData(username: String, password: String): home {
        val fragment = home()
        val bundle = Bundle()
        bundle.putString("usernameK", username)
        bundle.putString("passwordK", password)
        fragment.setArguments(bundle)

        return fragment
    }
}
