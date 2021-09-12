package edu.kiet.wifionoff

import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import edu.kiet.wifionoff.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnWifiOn.setOnClickListener(View.OnClickListener {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q)
            {
                val intent = Intent(Settings.Panel.ACTION_WIFI)
                startActivityForResult(intent,1)
            }
            else
            {
                val wifiManager =applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
                wifiManager.setWifiEnabled(true)
            }
        })
        binding.btnWifiOff.setOnClickListener(View.OnClickListener {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q)
            {
                val intent = Intent(Settings.Panel.ACTION_WIFI)
                startActivityForResult(intent,0)
            }
            else
            {
                val wifiManager =applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
                wifiManager.setWifiEnabled(false)
            }
        })
    }
}