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

    private lateinit var team1 : ImageView
    private lateinit var team2 : ImageView
    private lateinit var team3 : ImageView
    private lateinit var team4 : ImageView
    private lateinit var team5 : ImageView
    private lateinit var team6 : ImageView
    private lateinit var team7 : ImageView
    private lateinit var team8 : ImageView

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
            Toast.makeText(activity, "Team 1", Toast.LENGTH_SHORT).show()
            val mg = fragmentManager
            val member = member().setTeam("team1")
            mg!!.beginTransaction().replace(R.id.main_layout, member, "Fragment_member").addToBackStack("Fragment_member").commit()
        }
        team2.setOnClickListener{
            Toast.makeText(activity, "Team 2", Toast.LENGTH_SHORT).show()
            val mg = fragmentManager
            val member = member().setTeam("team2")
            mg!!.beginTransaction().replace(R.id.main_layout, member, "Fragment_member").addToBackStack("Fragment_member").commit()
        }
        team3.setOnClickListener{
            Toast.makeText(activity, "Team 3", Toast.LENGTH_SHORT).show()
            val mg = fragmentManager
            val member = member().setTeam("team3")
            mg!!.beginTransaction().replace(R.id.main_layout, member, "Fragment_member").addToBackStack("Fragment_member").commit()
        }
        team4.setOnClickListener{
            Toast.makeText(activity, "Team 4", Toast.LENGTH_SHORT).show()
            val mg = fragmentManager
            val member = member().setTeam("team4")
            mg!!.beginTransaction().replace(R.id.main_layout, member, "Fragment_member").addToBackStack("Fragment_member").commit()
        }
        team5.setOnClickListener{
            Toast.makeText(activity, "Team 5", Toast.LENGTH_SHORT).show()
            val mg = fragmentManager
            val member = member().setTeam("team5")
            mg!!.beginTransaction().replace(R.id.main_layout, member, "Fragment_member").addToBackStack("Fragment_member").commit()
        }
        team6.setOnClickListener{
            Toast.makeText(activity, "Team 6", Toast.LENGTH_SHORT).show()
            val mg = fragmentManager
            val member = member().setTeam("team6")
            mg!!.beginTransaction().replace(R.id.main_layout, member, "Fragment_member").addToBackStack("Fragment_member").commit()
        }
        team7.setOnClickListener{
            Toast.makeText(activity, "Team 7", Toast.LENGTH_SHORT).show()
            val mg = fragmentManager
            val member = member().setTeam("team7")
            mg!!.beginTransaction().replace(R.id.main_layout, member, "Fragment_member").addToBackStack("Fragment_member").commit()
        }
        team8.setOnClickListener{
            Toast.makeText(activity, "Team 85", Toast.LENGTH_SHORT).show()
            val mg = fragmentManager
            val member = member().setTeam("team8")
            mg!!.beginTransaction().replace(R.id.main_layout, member, "Fragment_member").addToBackStack("Fragment_member").commit()
        }

        return view
    }




}
