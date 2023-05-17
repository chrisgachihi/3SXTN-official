package com.example.bottom

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class DrillsActivity : AppCompatActivity() {
    lateinit var mListDrills: ListView
    lateinit var btnAddDrill: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drills)
        btnAddDrill = findViewById(R.id.fb_add_drill)
        mListDrills = findViewById(R.id.mListView)
        var drills:ArrayList<Drills> = ArrayList()
        var myAdapter = DrillsAdapter(this,drills)
        var progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")

        btnAddDrill.setOnClickListener {
            var intent = Intent(this,AddDrill::class.java)
            startActivity(intent)
        }


        var db = FirebaseDatabase.getInstance().reference.child("Drills")

        progress.show()
        db.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                drills.clear()
                for (snap in p0.children){
                    var drill = snap.getValue(Drills::class.java)
                    drills.add(drill!!)
                }
                myAdapter.notifyDataSetChanged()
            }
            override fun onCancelled(p0: DatabaseError) {
                progress.dismiss()
                Toast.makeText(applicationContext,"DB Locked",Toast.LENGTH_LONG).show()
            }
        })
        mListDrills.adapter = myAdapter
    }
}