package com.example.midterm

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class detail : Fragment() {

    lateinit var firstname: String
    lateinit var lastname: String
    lateinit var position: String
    lateinit var image: String
    lateinit var html: String
    lateinit var css: String
    lateinit var php: String
    lateinit var sql: String
    lateinit var javascript: String

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        // Inflate the layout for this fragment
        val bundle = arguments;
        if (bundle != null) {              // If arguments have some data
            firstname = bundle.getString("firstname").toString()
            lastname = bundle.getString("lastname").toString()
            position = bundle.getString("position").toString()
            image = bundle.getString("image").toString()
            html = bundle.getString("html").toString()
            css = bundle.getString("css").toString()
            php = bundle.getString("php").toString()
            sql = bundle.getString("sql").toString()
            javascript = bundle.getString("javascript").toString()
        }else {                            // Else no data from arguments

        }

        val imageTag = view.findViewById<ImageView>(R.id.imgProfile)
        val nameTag = view.findViewById<TextView>(R.id.textName)
        val posText = view.findViewById<TextView>(R.id.textPos)
        val htmlTag = view.findViewById<TextView>(R.id.textHtml)
        val cssTag = view.findViewById<TextView>(R.id.textCss)
        val phpTag = view.findViewById<TextView>(R.id.textPhp)
        val sqlTag = view.findViewById<TextView>(R.id.textSql)
        val jsTag = view.findViewById<TextView>(R.id.textJs)

        nameTag.text = "$firstname $lastname"
        posText.text = position
        htmlTag.text = "HTML Languate : $html"
        cssTag.text = "CSS Languate : $css"
        jsTag.text = "JavaScript Languate : $javascript"
        phpTag.text = "PHP Languate : $php"
        sqlTag.text = "SQL Languate : $sql"

        Glide.with(this)
            .load(image)
            .into(imageTag)

        return view
    }

    fun sendData(firstname: String, lastname: String, position: String, image: String, html: String, css: String, php: String, sql: String, javascript: String): detail {
        val fragment = detail()
        val bundle = Bundle()
        bundle.putString("firstname", firstname)
        bundle.putString("lastname", lastname)
        bundle.putString("position", position)
        bundle.putString("image", image)
        bundle.putString("html", html)
        bundle.putString("css", css)
        bundle.putString("php", php)
        bundle.putString("sql", sql)
        bundle.putString("javascript", javascript)
        fragment.setArguments(bundle)

        return fragment
    }

}
