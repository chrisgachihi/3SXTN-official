package com.example.bottom

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.util.Calendar

class DashActivity : AppCompatActivity() {
    lateinit var imgCalendar: ImageView
    lateinit var imgWorkouts: ImageView
    lateinit var imgAdd: ImageView
    lateinit var imgCrossfit: ImageView
    lateinit var tvCalendar: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)
        imgCalendar = findViewById(R.id.imgCalendar)
        imgWorkouts = findViewById(R.id.imgWorkouts)
        imgAdd = findViewById(R.id.imgAdd)
        imgCrossfit = findViewById(R.id.imgCrossfit)
        tvCalendar = findViewById(R.id.mTvCalendar)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        imgCalendar.setOnClickListener {
            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { _, mYear, mMonth, mDay ->
                    tvCalendar.setText(""+mDay +"/"+ mMonth +"/"+ mYear)
                }, year, month, day)
            dpd.show()
        }
        imgWorkouts.setOnClickListener {
            var intent = Intent(this,DrillsActivity::class.java)
            startActivity(intent)
        }
        imgAdd.setOnClickListener {
            var intent = Intent(this,AddDrill::class.java)
            startActivity(intent)
        }
        imgCrossfit.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data= Uri.parse("https://www.crossfit.com/workout")

            startActivity(openURL)
        }

    }
}