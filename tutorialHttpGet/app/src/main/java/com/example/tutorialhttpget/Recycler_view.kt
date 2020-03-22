package com.example.tutorialhttpget

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class Recycler_view : Fragment() {

    override fun onCreateView(inflater : LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        // Inflate the layout for this fragment

        var text = view.findViewById<TextView>(R.id.texsAll)

        //Some url endpoint that you may have
        val myUrl = "http://dummy.restapiexample.com/api/v1/employees"

        //String to place our result in
        val result : String

        //Instantiate new instance of our class
        val getRequest = HttpGetRequest()

        //Perform the doInBackground method, passing in our url
        result = getRequest.execute(myUrl).get()

        // Test show data form JSON file
        text.text = result

        val json = JSONObject(result)
        val jsonArray = json.getJSONArray("data")

        val recyclerView: RecyclerView = view.findViewById(R.id.recyLayout)

        // ตั้งค่า Layout
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity!!.baseContext)
        recyclerView.layoutManager = layoutManager

        // ตั้งค่า Adapter
        val adapter = MyRecyclerAdapter(activity!!, activity!!.baseContext,jsonArray)
        recyclerView.adapter = adapter

        return view
    }

}
