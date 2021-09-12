package edu.kiet.asynctaskkotlin

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import edu.kiet.asynctaskkotlin.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

lateinit var binding:ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnImageLoad.setOnClickListener(View.OnClickListener {
            getImageByCoroutines()
        })
    }
    private fun getImageByCoroutines()
    {
            GlobalScope.launch (Dispatchers.IO){
                val myurl =URL("https://i.ytimg.com/vi/D6Lbs8ln49s/maxresdefault.jpg")
                val httpURLConnection = myurl.openConnection() as HttpURLConnection
                httpURLConnection.connect()
                var bitmap = BitmapFactory.decodeStream(httpURLConnection.inputStream)
                launch (Dispatchers.Main) {
                    binding.imageView.setImageBitmap(bitmap)
                }
            }
    }
}


