package com.example.chordify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class CreateLineup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_lineup)

        val cancelButton = findViewById<View>(R.id.cancelbtn) as Button
        cancelButton.setOnClickListener{
            finish()
        }
        val createbackButton = findViewById<View>(R.id.backbuttoncreate) as ImageButton
        createbackButton.setOnClickListener{
            startActivity(Intent(this@CreateLineup, LineUp::class.java))
        }
    }
}