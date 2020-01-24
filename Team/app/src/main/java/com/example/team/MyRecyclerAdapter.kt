package com.example.team

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.json.JSONArray

class MyRecyclerAdapter(fragment: FragmentActivity, val dataSource: JSONArray) : RecyclerView.Adapter<MyRecyclerAdapter.Holder>() {

    private val thiscontext : Context = fragment.baseContext
    private val thisFragment = fragment

    class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private val View = view;

        lateinit var layout : LinearLayout
        lateinit var titleTextView: TextView
        lateinit var detailTextView: TextView
        lateinit var image: ImageView
        lateinit var imageURL: String
        lateinit var position: String
        lateinit var facebookURL: String

        fun Holder(){

            layout = View.findViewById<View>(R.id.recyview_LayputMember) as LinearLayout
            titleTextView = View.findViewById<View>(R.id.tv_name) as TextView
            detailTextView = View.findViewById<View>(R.id.tv_description) as TextView
            image = View.findViewById<View>(R.id.imgV) as ImageView

        }

    }


    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.recy_layout_member, parent, false))
    }


    override fun getItemCount(): Int {
        return dataSource.length()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.Holder()

        holder.titleTextView.text = dataSource.getJSONObject(position).getString("Name").toString()
        holder.detailTextView.text = dataSource.getJSONObject(position).getString("Description").toString()
        holder.position = dataSource.getJSONObject(position).getString("Position").toString()
        holder.facebookURL = dataSource.getJSONObject(position).getString("facebookURL").toString()
        holder.imageURL = dataSource.getJSONObject(position).getString("imageURL").toString()



        Glide.with(thiscontext)
            .load(dataSource.getJSONObject(position).getString("imageURL").toString())
            .into(holder.image)

        holder.layout.setOnClickListener{

            val arrString = arrayOf(holder.titleTextView.text,  holder.detailTextView.text, holder.position, holder.imageURL, holder.facebookURL) as Array
//            Toast.makeText(thiscontext,holder.titleTextView.text.toString(),Toast.LENGTH_SHORT).show()

            val MemberDetail = memberDetail().newIntent(arrString)
            val fm = thisFragment.supportFragmentManager
            val transaction : FragmentTransaction =  fm.beginTransaction()
            transaction.replace(R.id.main_layout, MemberDetail,"fragment_MemberDetail").addToBackStack("fragment_MemberDetail").commit()

        }

    }



}

