package com.example.bottom

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import com.google.firebase.database.FirebaseDatabase
import android.widget.Toast



class AddDrill : AppCompatActivity() {
    lateinit var edtTitle: EditText
    lateinit var edtDrill: EditText
    lateinit var imgDone: ImageView
    lateinit var imgBack: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_drill)
        edtTitle = findViewById(R.id.edt_title)
        edtDrill = findViewById(R.id.edt_drill)
        imgDone = findViewById(R.id.img_check)
        imgBack = findViewById(R.id.img_back_arrow)


        imgDone.setOnClickListener {
            var title = edtTitle.text.toString().trim()
            var drill = edtDrill.text.toString().trim()
            var id = System.currentTimeMillis().toString()
            if (title.isEmpty()) {
                edtTitle.setError("Please fill this input")
                edtTitle.requestFocus()
            } else if (drill.isEmpty()) {
                edtDrill.setError("Please fill this input")
                edtDrill.requestFocus()
            } else {
                var drillData = Drills(title,drill)
                var ref = FirebaseDatabase.getInstance().getReference().child("Drills/$id")
                ref.setValue(drillData).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Drill submitted successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Drill submission failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            imgBack.setOnClickListener {
                var intent = Intent(this, DashActivity::class.java)
                startActivity(intent)
            }

        }
    }
}