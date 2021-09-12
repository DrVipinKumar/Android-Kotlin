package edu.kiet.listingexample

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.kiet.listingexample.MyAdapter.MyViewHolder

class MyAdapter(var context: Context, var images: Array<Int>, var titles: ArrayList<String>):
    RecyclerView.Adapter<MyViewHolder>(){


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val image:ImageView=itemView.findViewById(R.id.images)
            val title:TextView=itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.list_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.image.setImageResource(images[position])
        holder.title.text=titles[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }


}