package com.example.listview2


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class fragment_list_view : Fragment() {

    private lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment_list_view, container, false)

        listView = view.findViewById(R.id.listview)

        val jsonString : String = loadJsonFromAsset("recipes.json", activity!!.baseContext).toString()
        val json = JSONObject(jsonString)
        val jsonArray = json.getJSONArray("recipes")

        val adapter = CustomAdapter(activity!!.baseContext, jsonArray)
        listView.adapter = adapter


        listView.setOnItemClickListener() { parent: AdapterView<*>, view:View, position:Int, id:Long ->
            val content  = parent.getItemAtPosition(position).toString()
            val obj = JSONObject(content)

            val image:String = obj.get("image").toString()
            val title:String = obj.get("title").toString()
            val description:String = obj.get("description").toString()

            Toast.makeText(context, "Select $title",Toast.LENGTH_SHORT).show()

            val detail = new_year().setData(title,description,image)
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.Layout,detail,"detail")
            transaction.addToBackStack("detail")
            transaction.commit()
        }

        return view
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
