package com.example.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (private var titles:List<String>,private var details:List<String>,private var images:List<Int>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()
{
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {

        val itemTitle:TextView=itemView.findViewById(R.id.title)
        val itemDetail:TextView=itemView.findViewById(R.id.description)
        val itemPicture:ImageView=itemView.findViewById(R.id.image)
        init {
            itemView.setOnClickListener{v:View->
                val position:Int=adapterPosition
                Toast.makeText(itemView.context,"The temperature in ${titles.get(position)} is ${details.get(position)}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val v:View= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text=titles[position]
        holder.itemDetail.text=details[position]
        holder.itemPicture.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

}