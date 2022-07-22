package com.example.chordify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KClass

class SongList : AppCompatActivity() {
    // on below line we are
    // creating variables for listview
    lateinit var programmingLangauegsLV: ListView

    // creating array adapter for listview
    lateinit var listAdapter: ArrayAdapter<String>

    // creating array list for listview
    lateinit var programmingLanguagesList: ArrayList<String>;

    // creating variable for searchview
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)
        // initializing variables of list view with their ids.
        programmingLangauegsLV = findViewById(R.id.listviewsongs)
        searchView = findViewById(R.id.searchsongs)

        // initializing list and adding data to list
        programmingLanguagesList = ArrayList()
        programmingLanguagesList.add(" ")
        programmingLanguagesList.add("C")
        programmingLanguagesList.add("C#")
        programmingLanguagesList.add("Java")
        programmingLanguagesList.add("Javascript")
        programmingLanguagesList.add("Python")
        programmingLanguagesList.add("Dart")
        programmingLanguagesList.add("Kotlin")
        programmingLanguagesList.add("Typescript")
        programmingLanguagesList.add("Typescript")
        programmingLanguagesList.add("Typescript")
        programmingLanguagesList.add("Typescript")
        programmingLanguagesList.add("Typescript")
        programmingLanguagesList.add("Typescript")
        programmingLanguagesList.add("Typescript")
        programmingLanguagesList.add("Typescript")
        programmingLanguagesList.add("Typescript")


        // initializing list adapter and setting layout
        // for each list view item and adding array list to it.
        listAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            programmingLanguagesList
        )
        // on below line setting list
        // adapter to our list view.
        programmingLangauegsLV.adapter = listAdapter

        programmingLangauegsLV.setOnItemClickListener { parent, view, position, id ->
            val element = parent.getItemAtPosition(position) // The item that was clicked
            val intent = Intent(this, Song::class.java)
            startActivity(intent)

        }


        // on below line we are adding on query
        // listener for our search view.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
                if (programmingLanguagesList.contains(query)) {
                    // if query exist within list we
                    // are filtering our list adapter.
                    listAdapter.filter.filter(query)
                } else {
                    // if query is not present we are displaying
                    // a toast message as no  data found..
                    Toast.makeText(this@SongList, "No Language found..", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }



            override fun onQueryTextChange(newText: String?): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
                listAdapter.filter.filter(newText)
                return false

            }
        })



        val back2 = findViewById<View>(R.id.backbutton1) as ImageButton
        back2.setOnClickListener {
            startActivity(Intent(this@SongList, MainActivity::class.java))

        }
    }
}



