package com.example.listview2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

/**
 * A simple [Fragment] subclass.
 */
class new_year : Fragment() {

    private lateinit var title : TextView
    private lateinit var detail : TextView
    private  lateinit var img: ImageView
    private  lateinit var textTitle : String
    private  lateinit var textDetail: String
    private  lateinit var textURLimg: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_new_year, container, false)

        this.title = view.findViewById(R.id.textTitle)
        this.detail = view.findViewById(R.id.textDetail)
        this.img = view.findViewById(R.id.imageView)

        val bundle = arguments

        if(bundle != null){
            this.textTitle = bundle.getString("title").toString()
            this.textDetail = bundle.getString("detail") .toString()
            this.textURLimg = bundle.getString("image") .toString()

            this.title.text = this.textTitle
            this.detail.text = this.textDetail
            val url = this.textURLimg

            Glide.with(activity!!.baseContext)
                  .load(url)
                  .into(this.img)
        }

        return view
    }

    fun setData(title: String, detail: String, image: String): new_year {
        val fragment = new_year()
        val bundle = Bundle()
        bundle.putString("title", title)
        bundle.putString("detail", detail)
        bundle.putString("image", image)
        fragment.arguments = bundle

        return fragment
    }
}
