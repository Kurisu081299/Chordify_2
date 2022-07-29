package com.example.chordify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class AddLineup : AppCompatActivity() {

    private lateinit var dbref2 : DatabaseReference
    private lateinit var songSearch : EditText
    private lateinit var lineRecyclerView: RecyclerView
    private lateinit var lineArrayList : ArrayList<LineupInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_lineup)

        lineRecyclerView = findViewById(R.id.recyclerviewaddlineup)
        lineRecyclerView.layoutManager = LinearLayoutManager(this)
        lineRecyclerView.setHasFixedSize(true)

        lineArrayList = arrayListOf<LineupInfo>()
        getlineData()


        val back1 = findViewById<View>(R.id.backbutton3) as ImageButton
        back1.setOnClickListener {
            startActivity(Intent(this@AddLineup, SongList::class.java))
        }
    }
    private fun getlineData() {

        dbref2 = FirebaseDatabase.getInstance().getReference("Lineup")

        dbref2.addValueEventListener(object: ValueEventListener {


            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    for (lineSnapshot in snapshot.children){

                        val line = lineSnapshot.getValue(LineupInfo::class.java)
                        lineArrayList.add(line!!)
                    }

                    lineRecyclerView.adapter = MyAdapter2(lineArrayList)

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}