package com.example.bottom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnSignup: Button
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSignup = findViewById(R.id.mBtnSignup)
        btnLogin = findViewById(R.id.mBtnLogin)

        btnSignup.setOnClickListener {
            var intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}