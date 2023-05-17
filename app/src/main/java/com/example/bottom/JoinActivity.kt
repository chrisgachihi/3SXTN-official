package com.example.bottom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class JoinActivity : AppCompatActivity() {
    lateinit var btnGym: Button
    lateinit var btnAthlete: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
        btnGym = findViewById(R.id.mBtnLocal)
        btnAthlete = findViewById(R.id.mBtnAthlete)

        btnGym.setOnClickListener {
            var intent = Intent(this,GymActivity::class.java)
            startActivity(intent)
        }
        btnAthlete.setOnClickListener {
            var intent = Intent(this,DashActivity::class.java)
            startActivity(intent)
        }
    }
}