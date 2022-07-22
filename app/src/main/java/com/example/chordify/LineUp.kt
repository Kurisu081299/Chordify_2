package com.example.chordify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class LineUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_up)
        val back1 = findViewById<View>(R.id.backbutton2) as ImageButton
        back1.setOnClickListener {
            startActivity(Intent(this@LineUp, MainActivity::class.java))
        }
    }
}