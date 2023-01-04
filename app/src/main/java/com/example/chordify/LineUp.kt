package com.example.chordify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class LineUp : AppCompatActivity() {

    private lateinit var dbref1 : DatabaseReference
    private lateinit var songSearch : EditText
    private lateinit var lineRecyclerView: RecyclerView
    private lateinit var lineArrayList : ArrayList<LineupInfo>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_up)

        lineRecyclerView = findViewById(R.id.recyclerviewlineup)
        lineRecyclerView.layoutManager = LinearLayoutManager(this)
        lineRecyclerView.setHasFixedSize(true)

        lineArrayList = arrayListOf<LineupInfo>()
        getlineData()


        val back1 = findViewById<View>(R.id.backbutton2) as ImageButton
        back1.setOnClickListener {
            startActivity(Intent(this@LineUp, MainActivity::class.java))
        }
        val create = findViewById<View>(R.id.addLineupbtn) as Button
        create.setOnClickListener {
            startActivity(Intent(this@LineUp, CreateLineup::class.java))
        }
    }

    private fun getlineData() {

        dbref1 = FirebaseDatabase.getInstance().getReference("Lineup")

        dbref1.addValueEventListener(object: ValueEventListener {


            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    for (lineSnapshot in snapshot.children){

                        val line = lineSnapshot.getValue(LineupInfo::class.java)
                        lineArrayList.add(line!!)
                    }

                    var lineadapter = MyAdapter2(lineArrayList)
                    lineRecyclerView.adapter = lineadapter
                    lineadapter.setOnItemClickListener(object : MyAdapter2.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@LineUp, ViewLineup::class.java)
                            intent.putExtra("name1",lineArrayList[position].name)
                            intent.putExtra("desc1",lineArrayList[position].desc)
                            startActivity(intent)

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