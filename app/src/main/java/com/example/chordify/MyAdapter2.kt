package com.example.chordify

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter2(private val lineupInfos : ArrayList<LineupInfo>) : RecyclerView.Adapter<MyAdapter2.MyViewHolder1>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter2.MyViewHolder1 {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lineup_item, parent, false)
        return MyAdapter2.MyViewHolder1(itemView)

    }

    override fun onBindViewHolder(holder:MyViewHolder1, position: Int) {
        val currentitem = lineupInfos[position]

        holder.name.text = currentitem.name
        holder.desc.text = currentitem.desc

    }

    override fun getItemCount(): Int {
        return lineupInfos.size
    }

    class MyViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name : TextView = itemView.findViewById(R.id.tvlineupname)
        val desc : TextView = itemView.findViewById(R.id.tvdesc)



    }




}