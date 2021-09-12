package edu.kiet.wifibluetoothexample

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import edu.kiet.wifibluetoothexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bluetoothManager=applicationContext.getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        val bluetoothAdapter=bluetoothManager.adapter
        binding.btnBlueon.setOnClickListener(View.OnClickListener {
            if(!bluetoothAdapter.isEnabled)
            {
                val intent=Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(intent,1)
            }
        })
        binding.btnBlueoff.setOnClickListener(View.OnClickListener {
            bluetoothAdapter.disable()
        })
        binding.btnShowBlue.setOnClickListener(View.OnClickListener {
            var bluetoothpaireddevices=bluetoothAdapter.bondedDevices
            var data:StringBuffer= StringBuffer()
            for(bluetoothdevices:BluetoothDevice in bluetoothpaireddevices)
            {
                data.append("Device name="+bluetoothdevices.name+"Address="+bluetoothdevices.address)
            }
            Toast.makeText(applicationContext,data,Toast.LENGTH_SHORT).show()
        })
        binding.btnWifion.setOnClickListener(View.OnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val panelIntent = Intent(Settings.Panel.ACTION_WIFI)
                startActivityForResult(panelIntent, 1);
            } else {
                // if it is Android Q and above go for the newer way
                val wmgr = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                wmgr.setWifiEnabled(true)
            }

        })
        binding.btnWifioff.setOnClickListener(View.OnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val panelIntent = Intent(Settings.Panel.ACTION_WIFI)
                startActivityForResult(panelIntent, 0);
            } else {
                // if it is Android Q and above go for the newer way
                val wmgr = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                wmgr.setWifiEnabled(false)
            }
        })

    }
}