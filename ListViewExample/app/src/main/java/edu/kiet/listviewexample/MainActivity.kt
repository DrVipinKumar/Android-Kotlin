package edu.kiet.listviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import edu.kiet.listviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var images=arrayOf(R.drawable.blub,R.drawable.bookmark,R.drawable.cup,R.drawable.flag,R.drawable.monitor
        ,R.drawable.mouse,R.drawable.music,R.drawable.person,R.drawable.printer)
        var items= arrayListOf<String>("Blub","Bookmark","Cup","Flag","Monitor","Mouse","Music","Person","Printer")
       // var adapter=ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_list_item_1,items)
        var adapter=MyAdapter(this@MainActivity,images,items)
        binding.listview.adapter=adapter
        binding.listview.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, position, l ->
            Toast.makeText(applicationContext,"You Selected "+adapterView.adapter.getItem(position),Toast.LENGTH_SHORT).show()
        })
            registerForContextMenu(binding.listview)
    }

    override fun onCreateContextMenu(menu: ContextMenu?,v: View?,menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu!!.setHeaderTitle("Context Menu")
        menu.add(0,v!!.id,0,"Add")
        menu.add(0,v.id,0,"Delete")
        menu.add(0,v!!.id,0,"Update")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when{
            item!!.title=="Add"->
                Toast.makeText(applicationContext,"You selected Add",Toast.LENGTH_SHORT).show()
            item!!.title=="Delete"->
                Toast.makeText(applicationContext,"You selected Add",Toast.LENGTH_SHORT).show()
            item!!.title=="Update"->
                Toast.makeText(applicationContext,"You selected Add",Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }
}