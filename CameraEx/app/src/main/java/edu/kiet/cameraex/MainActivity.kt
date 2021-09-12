package edu.kiet.cameraex

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import edu.kiet.cameraex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPopup.setOnClickListener(View.OnClickListener {
            var popupMenu:PopupMenu = PopupMenu(this@MainActivity,binding.btnPopup)
            popupMenu.menuInflater.inflate(R.menu.optionmenu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(object:PopupMenu.OnMenuItemClickListener{
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when{
                        item!!.itemId==R.id.menuitem2->Toast.makeText(applicationContext,"You Clicked Menu Item2",Toast.LENGTH_SHORT).show()
                    }
                    return true
                }

            })
            popupMenu.show()
        })
        binding.btnCamera.setOnClickListener(View.OnClickListener {
            var intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            activityResultLauncher.launch(intent)
        })
        activityResultLauncher=
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
                if(result!!.resultCode==Activity.RESULT_OK)
                {
                    var bitmap =result!!.data!!.extras!!.get("data") as Bitmap
                    binding.image.setImageBitmap(bitmap)
                }
                else
                {
                    Toast.makeText(applicationContext,"Image not clicked",Toast.LENGTH_SHORT).show()
                }
            }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when{
            item.itemId==R.id.menuitem1-> Toast.makeText(applicationContext,"You clicked Menu Item1",Toast.LENGTH_SHORT).show()

        }
        return super.onOptionsItemSelected(item)
    }


}