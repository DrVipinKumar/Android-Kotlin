package edu.kiet.recyclerviewwithkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(context:Context,imageName: ArrayList<Int>,imageTitle: ArrayList<String>):RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    var context:Context=context;
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var iname: ImageView =itemView.findViewById(R.id.imageName);
        var ititle: TextView =itemView.findViewById(R.id.imageTitle);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view:View =LayoutInflater.from(parent.context).inflate(R.layout.recyclerlayout,parent,false);
        return MyViewHolder(view);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.iname.setImageResource(imageName[position]);
        holder.ititle.setText(imageTitle[position]);
        holder.iname.setOnClickListener(View.OnClickListener { v: View? ->
            Toast.makeText(context,"You checked on "+imageTitle[position], Toast.LENGTH_SHORT).show();
        })
    }

    override fun getItemCount(): Int {
        return imageName.size;
    }

}
