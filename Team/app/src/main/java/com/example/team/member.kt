package com.example.team


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class member : Fragment() {

    private var teamNo: String = "team2"

    override fun onCreateView(inflater : LayoutInflater
                              ,container: ViewGroup?
                              ,savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_member, container, false)
        // Inflate the layout for this fragment

        val bundle = arguments;
        if (bundle != null) {              // If arguments have some data
            teamNo = bundle.getString("key_Number").toString()
        }

        val jsonString : String = loadJsonFromAsset("member.json", activity!!.baseContext).toString()
        val json = JSONObject(jsonString)
        val jsonArray = json.getJSONArray(teamNo)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyLayoutMember)

        //ตั้งค่า Layout
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity!!.baseContext)
        recyclerView.layoutManager = layoutManager

        //ตั้งค่า Adapter
        val adapter = MyRecyclerAdapter(activity!!.baseContext,jsonArray)
        recyclerView.adapter = adapter

        return view
    }

    fun setTeam(number: String): member {
        val fragment = member()
        val bundle = Bundle()

        bundle.putString("key_Number", number)
        fragment.setArguments(bundle)

        return fragment
    }

    private fun loadJsonFromAsset(filename: String, context: Context): String? {
        val json: String?

        try {
            val inputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: java.io.IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }




}
