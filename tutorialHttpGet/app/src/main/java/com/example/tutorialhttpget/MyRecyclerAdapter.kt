package com.example.tutorialhttpget

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray


class MyRecyclerAdapter(fragmentActivity: FragmentActivity, context: Context, val dataSource: JSONArray) : RecyclerView.Adapter<MyRecyclerAdapter.Holder>() {

    private val thiscontext : Context = context
    private val thisActivity = fragmentActivity

    class Holder(view : View) : RecyclerView.ViewHolder(view) {

        private val View = view

        lateinit var layout : LinearLayout
        lateinit var text1: TextView
        lateinit var text2: TextView


        fun Holder(){
            layout = View.findViewById<View>(R.id.recyview_layout) as LinearLayout
            text1 = View.findViewById<View>(R.id.text1) as TextView
            text2 = View.findViewById<View>(R.id.text2) as TextView
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

        // แบบปกติ
        // สำหรับ http://dummy.restapiexample.com/api/v1/employees
        holder.text1.text = ( dataSource.getJSONObject(position).getString("id").toString() + ". " + dataSource.getJSONObject(position).getString("employee_name").toString() )
        holder.text2.text = ( dataSource.getJSONObject(position).getString("employee_salary").toString() )

        // สำหรับการใส่รูป
        // Glide.with(thiscontext)
            // .load(dataSource.getJSONObject(position).getString("image").toString())
            // .into(holder.image)

        holder.layout.setOnClickListener{
            // สร้าง Dialog
            val builder: AlertDialog.Builder = AlertDialog.Builder(thisActivity)
            // กำหนดข้ิอความให้ Dialog
            builder.setMessage("แสดงข้อมูล")
            // กำหนดปุ่มยืนยัน
            builder.setPositiveButton("ตกลง") { _, _ ->
                Toast.makeText(thiscontext, holder.text1.text , Toast.LENGTH_SHORT).show()
            }
            // กำหนดปุ่มยกเลิก
            builder.setNegativeButton("ยกเลิก") { _, _ ->
                Toast.makeText(thiscontext, "ขอบคุณครับ", Toast.LENGTH_SHORT).show()
            }
            // แสดง Dialog
            builder.show()

        }

        // Toast.makeText(thiscontext,holder.titleTextView.text.toString(),Toast.LENGTH_SHORT).show()

    }



}
