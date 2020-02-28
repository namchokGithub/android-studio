package com.example.graph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.ColorTemplate

/**
 * A simple [Fragment] subclass.
 */
class MainChart : Fragment() {

    lateinit var Bar_id : BarChart
    lateinit var Pie_id : PieChart
    lateinit var Line_id : LineChart

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main_chart, container, false)
        // Inflate the layout for this fragment

        Bar_id = view.findViewById(R.id.Bar_id)
        Pie_id = view.findViewById(R.id.pie_id)
        Line_id = view.findViewById(R.id.line_id)

        Bar_Chart(Bar_id)
        //Pie_Chart(Pie_id)
        //Line_Chart(Line_id)

        return view
    }

    fun Bar_Chart( chart : BarChart ){

        //ปิด Description
        chart.description.isEnabled = false

        //สุ่มข้อมูล 12 อัน
        val listStudent = Student.getSampleStudentData(12)

        //สร้าง ArrayList<BarEntry> ขึ้นมาเพื่อเก็บข้อมูลนักเรียน และใส่ข้อมูล ลงไปใน entry แต่ละตัว
        val entries: ArrayList<BarEntry> = ArrayList()
        var index : Float = 0F
        for (student in listStudent) {
            entries.add(BarEntry(index, student.score))
            index++
        }

        //ให้เอา entity ที่เราใส่ข้อมูลไว้ในเก็บใน BarDataSet
        //เราสามารถ set พวกสีของแท่ง แล้วก็ขนาดตัวหนังสือได้ด้วย
        val dataset = BarDataSet(entries, "Point of data")
        dataset.valueTextSize = 10F
        dataset.setColors(*ColorTemplate.VORDIPLOM_COLORS) // set the color

        //พอได้ dataset แล้ว ก็นำมาใส่ใน BarData
        //เราสามารถใส่ dataset ได้หลายตัว แล้วแต่การ add ลงใน List แต่ในกรณีนี้มีตัวเดียว
        val dataSets = ArrayList<IBarDataSet>()

        dataSets.add(dataset)

        val data = BarData(dataSets)

        //ขั้นตอนสุดท้ายของ การกำหนดข้อมูล คือใส่ data ลงใน chart ด้วย .setData(data)
        chart.setData(data)  // set data on chart.

        //กำหนดให้ตัวหนังสือที่ระบุชื่อ แสดงแค่ข้างล่าง และเอียง 80 องศา
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM)
        chart.getXAxis().setLabelRotationAngle(80F)

        val xAxis = chart.xAxis
        xAxis.setTextSize(10F)
//        xAxis.setCenterAxisLabels(false)

        //เซ้ทเส้นที่แสดง
        xAxis.granularity = 1f

        //กำหนดชื่อบนแกน X
        xAxis.setValueFormatter(object : ValueFormatter() {

            override fun getFormattedValue(value: Float): String? {

                if( value < 0 || value >= listStudent.size ){
                    return ""
                }
                else{
                    return listStudent[value.toInt()].name
                }

            }

        })

        //กำหนดข้อมูลฝั่งซ้าย
        val leftAxis = chart.axisLeft
        leftAxis.setLabelCount(8, false)
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        leftAxis.spaceTop = 15f
        leftAxis.axisMinimum = 0f // this replaces setStartAtZero(true)

        //กำหนดให้ตัวเลขด้านขวาไม่ต้องแสดง
        val rightAxis = chart.axisRight
//        rightAxis.setDrawGridLines(false)
//        rightAxis.setLabelCount(8, false)
//        rightAxis.spaceTop = 15f
//        rightAxis.axisMinimum = 0f // this replaces setStartAtZero(true)
        rightAxis.setEnabled(false)

        //กำหนด animation
        chart.animateY(3000)

    }


}
