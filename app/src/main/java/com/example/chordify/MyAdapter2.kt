package com.example.chordify

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter2(private val lineupInfos : ArrayList<LineupInfo>) : RecyclerView.Adapter<MyAdapter2.MyViewHolder1>() {

    private lateinit var linelistener : onItemClickListener


    interface onItemClickListener {

        fun onItemClick(position: Int)

    }


    fun setOnItemClickListener(listener: onItemClickListener){

        linelistener = listener


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder1 {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lineup_item, parent, false)
        return MyViewHolder1(itemView, linelistener)

    }

    override fun onBindViewHolder(holder:MyViewHolder1, position: Int) {
        val currentitem = lineupInfos[position]

        holder.name.text = currentitem.name
        holder.desc.text = currentitem.desc
        holder.name1.text = currentitem.name
        holder.desc1.text = currentitem.desc
        holder.name2.text = currentitem.name
        holder.desc2.text = currentitem.desc

    }

    override fun getItemCount(): Int {
        return lineupInfos.size
    }

    class MyViewHolder1(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val name : TextView = itemView.findViewById(R.id.tvlineupname)
        val desc : TextView = itemView.findViewById(R.id.tvdesc)
        val name1 :TextView = itemView.findViewById(R.id.tvlineuptitle)
        val desc1 : TextView = itemView.findViewById(R.id.tvdescription)
        val name2 : TextView = itemView.findViewById(R.id.tvlineupname2)
        val desc2 : TextView = itemView.findViewById(R.id.tvdesc2)

        init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }



    }




}