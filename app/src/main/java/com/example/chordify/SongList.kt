package com.example.chordify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlin.reflect.KClass

class SongList : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var songRecyclerView: RecyclerView
    private lateinit var songArrayList : ArrayList<SongsInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)

        songRecyclerView = findViewById(R.id.listviewsongs)
        songRecyclerView.layoutManager = LinearLayoutManager(this)
        songRecyclerView.setHasFixedSize(true)

        songArrayList = arrayListOf<SongsInfo>()
        getSongData()

        val back2 = findViewById<View>(R.id.backbutton1) as ImageButton
        back2.setOnClickListener {
            startActivity(Intent(this@SongList, MainActivity::class.java))

        }
    }

    private fun getSongData() {

        dbref = FirebaseDatabase.getInstance().getReference("Songs")

        dbref.addValueEventListener(object: ValueEventListener{


            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    for (songSnapshot in snapshot.children){

                        val song = songSnapshot.getValue(SongsInfo::class.java)
                        songArrayList.add(song!!)
                    }

                    songRecyclerView.adapter = MyAdapter(songArrayList)

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

}



