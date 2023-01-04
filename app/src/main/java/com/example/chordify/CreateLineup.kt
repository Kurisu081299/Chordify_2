package com.example.chordify

import android.content.Intent
import android.media.audiofx.AudioEffect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.chordify.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CreateLineup : AppCompatActivity() {

    private lateinit var lineupname : EditText
    private lateinit var description : EditText
    private lateinit var createbtn : Button
    private lateinit var createlineupDB : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_lineup)

        lineupname = findViewById(R.id.lineupName)
        description = findViewById(R.id.descriptiontext)
        createbtn = findViewById(R.id.newbtn)

        createlineupDB = FirebaseDatabase.getInstance().getReference("Lineup")

        createbtn.setOnClickListener{
            createLineup()
            finish()
        }



        val cancelButton = findViewById<View>(R.id.cancelbtn) as Button
        cancelButton.setOnClickListener{
            finish()
        }
        val createbackButton = findViewById<View>(R.id.backbuttoncreate) as ImageButton
        createbackButton.setOnClickListener{
            startActivity(Intent(this@CreateLineup, LineUp::class.java))
        }
    }

    private fun createLineup() {

        val etLineupname = lineupname.text.toString()
        val etDescription = description.text.toString()

        if (etLineupname.isEmpty()){
            lineupname.error = "Field must not be blank!"
        }
        if (etDescription.isEmpty()){
            description.error = "Field must not be blank!"
        }

        val lineID = createlineupDB.push().key!!

        val lineUpName = LineupInfo(lineID, etLineupname, etDescription)

        createlineupDB.child(lineID).setValue(lineUpName)
            .addOnCompleteListener{
                Toast.makeText(this, "Created New Lineup Successfully", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{ err ->
                Toast.makeText(this, "Try Again. ${err.message}", Toast.LENGTH_LONG).show()
            }

    }
}