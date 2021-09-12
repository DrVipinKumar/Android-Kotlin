package edu.kiet.listviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var context: Context, var images: Array<Int>, var items: ArrayList<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(p0: Int): Any {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, view: View?, p2: ViewGroup?): View {
        val viewHolder:ViewHolder;
        val rowView:View?
        if(view==null) {
            rowView = LayoutInflater.from(context).inflate(R.layout.list_layout, p2, false)
            viewHolder=ViewHolder(rowView)
            rowView.tag=viewHolder
        }
        else
        {
            rowView=view
            viewHolder=rowView.tag as ViewHolder
        }
        viewHolder.image.setImageResource(images[p0])
        viewHolder.item.text=items[p0]
        return rowView!!
    }
    class ViewHolder(view:View?)
    {
        val image:ImageView=view!!.findViewById<ImageView>(R.id.imageView)
        val item: TextView =view!!.findViewById<TextView>(R.id.textView)
    }


}
