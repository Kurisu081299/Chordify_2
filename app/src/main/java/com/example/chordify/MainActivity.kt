package com.example.chordify

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val songButton = findViewById<View>(R.id.songlistbutton) as Button
        songButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, SongList::class.java))
        }
        val lineButton = findViewById<View>(R.id.lineupbutton2) as Button
        lineButton.setOnClickListener{
            startActivity(Intent(this@MainActivity, LineUp::class.java))
        }

    }
}