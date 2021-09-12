package edu.kiet.bluetoothexmaple

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import edu.kiet.bluetoothexmaple.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bluetoothManager=applicationContext.getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        val bluetoothAdapter=bluetoothManager.adapter
        binding.btnBluetoothOn.setOnClickListener(View.OnClickListener {
            val intent= Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(intent,1)
            Toast.makeText(applicationContext,"Bluetooth Enabled",Toast.LENGTH_SHORT).show()
        })
        binding.btnBluetoothOff.setOnClickListener(View.OnClickListener {
            bluetoothAdapter.disable()
            Toast.makeText(applicationContext,"Bluetooth Disabled",Toast.LENGTH_SHORT).show()
        })
        binding.btnBluetoothPaired.setOnClickListener(View.OnClickListener {
            var pairedDevices=bluetoothAdapter.bondedDevices
            var data:StringBuffer= StringBuffer()
            for(device:BluetoothDevice in pairedDevices)
            {
                data.append("Device Name="+device.name+" Device Address="+device.address)
            }
            if(data.isEmpty())
            {
                Toast.makeText(applicationContext,"Bluetooth Divices is not Paired",Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext, data, Toast.LENGTH_SHORT).show()
            }
        })
    }
}