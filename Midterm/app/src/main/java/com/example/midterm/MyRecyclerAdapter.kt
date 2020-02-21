package com.example.midterm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.json.JSONArray

class MyRecyclerAdapter(context: Context, val dataSource: JSONArray) : RecyclerView.Adapter<MyRecyclerAdapter.Holder>() {

    private val thiscontext : Context = context

    class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private val View = view;

        lateinit var layout : LinearLayout
        lateinit var nameTag: TextView
        lateinit var positionTag: TextView
        lateinit var imageTag: ImageView
        lateinit var firstname: String
        lateinit var lastname: String
        lateinit var position: String
        lateinit var image: String
        lateinit var html: String
        lateinit var css: String
        lateinit var php: String
        lateinit var sql: String
        lateinit var javascript: String


        fun Holder(){

            layout = View.findViewById<View>(R.id.recyview_layout) as LinearLayout
            nameTag = View.findViewById<View>(R.id.tv_name) as TextView
            positionTag = View.findViewById<View>(R.id.tv_description) as TextView
            imageTag = View.findViewById<View>(R.id.imgV) as ImageView

        }

    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.recy_layout, parent, false))
    }


    override fun getItemCount(): Int {
        return dataSource.length()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.Holder()

        holder.firstname = dataSource.getJSONObject(position).getString("firstname").toString()
        holder.lastname = dataSource.getJSONObject(position).getString("lastname").toString()
        holder.position = dataSource.getJSONObject(position).getString("position").toString()
        holder.image = dataSource.getJSONObject(position).getString("image").toString()
        holder.html = dataSource.getJSONObject(position).getString("html").toString()
        holder.css = dataSource.getJSONObject(position).getString("css").toString()
        holder.php = dataSource.getJSONObject(position).getString("php").toString()
        holder.sql = dataSource.getJSONObject(position).getString("sql").toString()
        holder.javascript = dataSource.getJSONObject(position).getString("javascript").toString()

        holder.nameTag.text = holder.firstname + " " + holder.lastname
        holder.positionTag.text = holder.position

        Glide.with(thiscontext)
            .load(holder.image)
            .into(holder.imageTag)

        holder.layout.setOnClickListener{

            val detail = detail().sendData(holder.firstname, holder.lastname, holder.position, holder.image, holder.html, holder.css, holder.php, holder.sql, holder.javascript )
            val manager = (holder.itemView.context as FragmentActivity).supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.layout, detail,"fragment_RecyclerView")
            transaction.addToBackStack("fragment_list_view")
            transaction.commit()


            Toast.makeText(thiscontext,holder.firstname, Toast.LENGTH_SHORT).show()

        }

    }


}

//val manager = (holder.itemView.context as FragmentActivity).supportFragmentManager