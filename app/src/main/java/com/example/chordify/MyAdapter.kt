package com.example.chordify

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextClock
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val songInfo : ArrayList<SongsInfo>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private lateinit var songlistener : onItemClickListener


interface onItemClickListener {

    fun onItemClick(position: Int)

    }


    fun setOnItemClickListener(listener: onItemClickListener){

        songlistener = listener


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.song_item, parent, false)
        return MyViewHolder(itemView, songlistener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = songInfo[position]

        holder.songTitle.text = currentitem.songTitle
        holder.singer.text = currentitem.singer
        holder.lyrics.text = currentitem.lyrics
        holder.key.text = currentitem.key



    }

    override fun getItemCount(): Int {
        return songInfo.size
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val songTitle : TextView = itemView.findViewById(R.id.tvsongtitle)
        val singer : TextView = itemView.findViewById(R.id.tvsinger)
        val lyrics : TextView = itemView.findViewById(R.id.tvcontentlyrics)
        val key : TextView = itemView.findViewById(R.id.tvkey)



        init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}