package edu.kiet.recyclerexample

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MyAdapter(var context: Context, var listing: ArrayList<DataItems>) : RecyclerView.Adapter<MyAdapter.ViewHolder>(), Filterable{

    var templisting=listing
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val image:ImageView=itemView.findViewById(R.id.image)
        val title:TextView=itemView.findViewById(R.id.imageName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(templisting.get(position).image)
        holder.title.text=templisting.get(position).title
        holder.title.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"You selected "+templisting.get(position).title,Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return templisting.size
    }

    override fun getFilter(): Filter {
        return object:Filter(){
            override fun performFiltering(searchinfo: CharSequence?): FilterResults {
                var filterlist=ArrayList<DataItems>()
                if(searchinfo!!.isEmpty() || searchinfo.length==0)
                {
                    filterlist=listing
                }
                else
                {
                    listing.forEach { dataItems ->
                        if(dataItems.title.toString().lowercase().contains(searchinfo.toString().lowercase()))
                        {
                            filterlist.add(dataItems)
                        }
                    }
                }
                var filterResults=FilterResults()
                filterResults.values=filterlist
                return filterResults
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(p0: CharSequence?, result: FilterResults?) {
                templisting= result!!.values as ArrayList<DataItems>
                notifyDataSetChanged()
            }

        }
    }

}

