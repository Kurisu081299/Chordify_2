package com.example.chordify

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val songInfo : ArrayList<SongsInfo>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.song_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = songInfo[position]

        holder.songTitle.text = currentitem.songTitle
        holder.singer.text = currentitem.singer
        holder.key.text = currentitem.key

    }

    override fun getItemCount(): Int {
        return songInfo.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val songTitle : TextView = itemView.findViewById(R.id.tvsongtitle)
        val singer : TextView = itemView.findViewById(R.id.tvsinger)
        val key : TextView = itemView.findViewById(R.id.tvkey)

    }


}