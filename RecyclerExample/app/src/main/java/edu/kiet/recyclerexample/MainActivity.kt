package edu.kiet.recyclerexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.SearchView
import androidx.recyclerview.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler=findViewById<RecyclerView>(R.id.recyclerView)
        var images= arrayOf(R.drawable.blub,R.drawable.bookmark,R.drawable.cup,R.drawable.monitor,R.drawable.mouse,
            R.drawable.music,R.drawable.flag,R.drawable.person,R.drawable.printer)
        var titles= arrayListOf<String>("Blub","Bookmark","Cup","Monitor","Mouse","Music","Flag","Person","Printer")
        var listing=ArrayList<DataItems>()
        for(i in 0..titles.size-1)
        {
            var dataitems =DataItems(images[i],titles[i])
            listing.add(dataitems)
        }
        adapter=MyAdapter(this@MainActivity,listing)
         recycler.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
        //recycler.layoutManager=GridLayoutManager(this@MainActivity,2)
        recycler.adapter=adapter
        val snapHelper:SnapHelper=PagerSnapHelper()
        snapHelper.attachToRecyclerView(recycler)

            }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.searchview,menu)
        var menuItem=menu!!.findItem(R.id.app_bar_search)
        var searchView=menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(searchdata: String?): Boolean {
                adapter.filter.filter(searchdata)
                adapter.notifyDataSetChanged()
                return false
            }
        })
        return true
    }

}

