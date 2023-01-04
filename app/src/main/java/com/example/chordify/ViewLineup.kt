package com.example.chordify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class ViewLineup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_lineup)

        val linetitle: TextView = findViewById(R.id.tvlineuptitle)
        val linedesc: TextView = findViewById(R.id.tvdescription)

        val bundle : Bundle ?= intent.extras
        val title = bundle!!.getString("name1")
        val descr = bundle!!.getString("desc1")

        linetitle.text = title
        linedesc.text = descr

        val lineButton = findViewById<View>(R.id.backbutton4) as ImageButton
        lineButton.setOnClickListener {
            startActivity(Intent(this@ViewLineup, LineUp::class.java))
        }
    }
}