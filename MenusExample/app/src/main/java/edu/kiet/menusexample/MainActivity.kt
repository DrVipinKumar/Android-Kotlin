package edu.kiet.menusexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val showPoup=findViewById<TextView>(R.id.showPopup)
        showPoup.setOnClickListener(View.OnClickListener {
            var popupMenu:PopupMenu= PopupMenu(this@MainActivity,showPoup)
            popupMenu.menuInflater.inflate(R.menu.option_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(object:PopupMenu.OnMenuItemClickListener{
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when{
                        item!!.itemId==R.id.menu1->
                            Toast.makeText(applicationContext,"You selected File",Toast.LENGTH_SHORT).show()
                        item.itemId==R.id.menu2->
                            Toast.makeText(applicationContext,"You selected Contact Us",Toast.LENGTH_SHORT).show()
                        item.itemId==R.id.menu3->
                            Toast.makeText(applicationContext,"You selected About Us",Toast.LENGTH_SHORT).show()
                    }
                    return true
                }

            })
            popupMenu.show()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when{
            item.itemId==R.id.menu1->
                Toast.makeText(applicationContext,"You selected File",Toast.LENGTH_SHORT).show()
            item.itemId==R.id.menu2->
                Toast.makeText(applicationContext,"You selected Contact Us",Toast.LENGTH_SHORT).show()
            item.itemId==R.id.menu3->
                Toast.makeText(applicationContext,"You selected About Us",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}