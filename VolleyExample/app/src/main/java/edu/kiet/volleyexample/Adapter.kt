package edu.kiet.volleyexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context,val userInfo:UserInfo): RecyclerView.Adapter<Adapter.ViewHolderAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter {
        val view=LayoutInflater.from(context).inflate(R.layout.layoutforrecycler,parent,false)
        return ViewHolderAdapter(view)
    }

    override fun getItemCount(): Int {
        return userInfo.size
    }
    class ViewHolderAdapter(itemView: View) :RecyclerView.ViewHolder(itemView){
        val userName: TextView =itemView.findViewById(R.id.txtUserName)
        val userImage: ImageView =itemView.findViewById(R.id.userImage)
    }

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) {
        Glide.with(context).load(userInfo.get(position).avatar_url).into(holder.userImage)
        holder.userName.text=userInfo.get(position).login
    }
}