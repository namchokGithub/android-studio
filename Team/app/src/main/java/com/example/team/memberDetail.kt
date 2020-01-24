package com.example.team

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide


class memberDetail : Fragment() {

    lateinit var name: String
    lateinit var position: String
    lateinit var description: String
    lateinit var image: String
    lateinit var facebook: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_member_detail, container, false)

        val textViewName = view.findViewById(R.id.textName) as TextView
        val textViewDes = view.findViewById(R.id.textDes) as TextView
        val textViewPos = view.findViewById(R.id.textPos) as TextView
        val imageV = view.findViewById(R.id.imageProfile) as ImageView

        val bundle = arguments;
        if (bundle != null) {              // If arguments have some data
            name = bundle.getString("name").toString()
            position = bundle.getString("pos").toString()
            image = bundle.getString("img").toString()
            description = bundle.getString("des").toString()
            facebook = bundle.getString("face").toString()

            textViewName.text = name
            textViewDes.text = description
            textViewPos.text = position

            Glide.with(this)
                .load(image)
                .into(imageV)

            Toast.makeText(activity, name,Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(activity, "No data",Toast.LENGTH_SHORT).show()
        }

        return  view
    }

    /*
     * Name : newIntent
     * Description : Send data from some to fragment to another fragment
     * Input : None
     * Output : this fragment
     * */
    fun newIntent(name: String, des: String, img: String, face: String, pos: String): memberDetail {
        val fragment = memberDetail()
        val bundle = Bundle()

        bundle.putString("name", name)
        bundle.putString("des", des )
        bundle.putString("img", img)
        bundle.putString("face", face)
        bundle.putString("pos", pos)

        fragment.setArguments(bundle)

        return fragment
    }
}
