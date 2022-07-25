package com.example.chordify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class Song : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)

        val songButton = findViewById<View>(R.id.backbutton3) as ImageButton
        songButton.setOnClickListener {
            startActivity(Intent(this@Song, SongList::class.java))
        }
    }
}