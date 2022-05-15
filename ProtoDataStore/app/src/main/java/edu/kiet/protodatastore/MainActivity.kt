package edu.kiet.protodatastore

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import edu.kiet.protodatastore.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var protoColor: ProtoColor
    var red:Int=0;var green:Int=0;var blue:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        protoColor= ProtoColor(applicationContext)
        binding.sbBlue.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                blue=p1
                binding.txtMsg.setTextColor(Color.rgb(red, green, blue))

            }
            override fun onStartTrackingTouch(p0: SeekBar?) {

            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
                    GlobalScope.launch(Dispatchers.Main) {
                        protoColor.ColorUpdate(red,green, blue)
                    }
            }

        })
        binding.sbRed.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                red=p1
                binding.txtMsg.setTextColor(Color.rgb(red, green, blue))

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                GlobalScope.launch(Dispatchers.Main) {
                    protoColor.ColorUpdate(red,green, blue)
                }
            }

        })
        binding.sbGreen.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                green=p1
                binding.txtMsg.setTextColor(Color.rgb(red, green, blue))

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                GlobalScope.launch(Dispatchers.Main) {
                    protoColor.ColorUpdate(red,green, blue)
                }
            }

        })
    }

    override fun onStart() {
        super.onStart()
        val colorInfo=protoColor.getColorInfo
        GlobalScope.launch (Dispatchers.Main){
            colorInfo.collect {
                red=it.red
                green=it.green
                blue=it.blue
                binding.sbRed.setProgress(red)
                binding.sbGreen.setProgress(green)
                binding.sbBlue.setProgress(blue)
                binding.txtMsg.setTextColor(Color.rgb(red, green, blue))
            }
        }

    }


}


