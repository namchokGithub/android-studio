package com.example.team


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

/**
 * A simple [Fragment] subclass.
 */
class home : Fragment() {

    lateinit var team1 : ImageView
    lateinit var team2 : ImageView
    lateinit var team3 : ImageView
    lateinit var team4 : ImageView
    lateinit var team5 : ImageView
    lateinit var team6 : ImageView
    lateinit var team7 : ImageView
    lateinit var team8 : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        team1 = view.findViewById(R.id.imgTeam1)
        team2 = view.findViewById(R.id.imgTeam2)
        team3 = view.findViewById(R.id.imgTeam3)
        team4 = view.findViewById(R.id.imgTeam4)
        team5 = view.findViewById(R.id.imgTeam5)
        team6 = view.findViewById(R.id.imgTeam6)
        team7 = view.findViewById(R.id.imgTeam7)
        team8 = view.findViewById(R.id.imgTeam8)

        team1.setOnClickListener{
            Toast.makeText(activity, "Hi there! This is a Toast 1.", Toast.LENGTH_SHORT).show()
        }
        team2.setOnClickListener{
            Toast.makeText(activity, "Hi there! This is a Toast 2.", Toast.LENGTH_SHORT).show()
        }
        team3.setOnClickListener{
            Toast.makeText(activity, "Hi there! This is a Toast 3.", Toast.LENGTH_SHORT).show()
        }
        team4.setOnClickListener{
            Toast.makeText(activity, "Hi there! This is a Toast 4.", Toast.LENGTH_SHORT).show()
        }
        team5.setOnClickListener{
            Toast.makeText(activity, "Hi there! This is a Toast 5.", Toast.LENGTH_SHORT).show()
        }
        team6.setOnClickListener{
            Toast.makeText(activity, "Hi there! This is a Toast 6.", Toast.LENGTH_SHORT).show()
        }
        team7.setOnClickListener{
            Toast.makeText(activity, "Hi there! This is a Toast 7.", Toast.LENGTH_SHORT).show()
        }
        team8.setOnClickListener{
            Toast.makeText(activity, "Hi there! This is a Toast 8.", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    /*
     * Name : newIntent
     * Description : Send data from some to fragment to another fragment
     * Input : None
     * Output : this fragment
     * */
    fun newIntent(): home {
        val fragment = home()
        val bundle = Bundle()
        fragment.setArguments(bundle)

        return fragment
    }


}
