package com.example.chordify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Song : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)

        val songtitle: TextView = findViewById(R.id.tvsongtitle)
        val titlesinger: TextView = findViewById(R.id.tvsinger)
        val songkey: TextView = findViewById(R.id.tvkey)
        val songlyrics: TextView = findViewById(R.id.tvcontentlyrics)


        val bundle : Bundle ?= intent.extras
        val title = bundle!!.getString("songTitle")
        val artist = bundle!!.getString("singer")
        val note = bundle!!.getString("key")
        val lyrics = bundle!!.getString("lyrics")


        songtitle.text = title
        titlesinger.text = artist
        songkey.text = note
        songlyrics.text = lyrics



        val songButton = findViewById<View>(R.id.backbutton3) as ImageButton
        songButton.setOnClickListener {
            startActivity(Intent(this@Song, SongList::class.java))
        }

        val viewlineup = findViewById<View>(R.id.viewlineup) as Button
        viewlineup.setOnClickListener {
            startActivity(Intent(this@Song, LineUp::class.java))
        }

       val addtolineup = findViewById<View>(R.id.add) as Button
        addtolineup.setOnClickListener {
            startActivity(Intent(this@Song, AddLineup::class.java))
        }
    }

}