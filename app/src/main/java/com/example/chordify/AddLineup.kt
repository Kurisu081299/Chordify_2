package com.example.chordify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class AddLineup : AppCompatActivity() {

    private lateinit var dbref2 : DatabaseReference
    private lateinit var songSearch : EditText
    private lateinit var lineupRecyclerView: RecyclerView
    private lateinit var lineupArrayList : ArrayList<LineupInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_lineup)

        lineupRecyclerView = findViewById(R.id.recyclerviewaddlineup)
        lineupRecyclerView.layoutManager = LinearLayoutManager(this)
        lineupRecyclerView.setHasFixedSize(true)

        lineupArrayList = arrayListOf<LineupInfo>()
        getlineData()


        val back5 = findViewById<View>(R.id.backbutton5) as ImageButton
        back5.setOnClickListener {
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
                        lineupArrayList.add(line!!)
                    }

                    var adapter2 = MyAdapter2(lineupArrayList)
                    lineupRecyclerView.adapter = adapter2
                    adapter2.setOnItemClickListener(object : MyAdapter2.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            Toast.makeText(applicationContext,"Added",Toast.LENGTH_SHORT).show()
                            finish()

                        }

                    })

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}