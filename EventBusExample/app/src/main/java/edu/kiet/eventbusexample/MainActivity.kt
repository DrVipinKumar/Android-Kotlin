package edu.kiet.eventbusexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import edu.kiet.eventbusexample.databinding.ActivityMainBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        EventBus.getDefault().register(this)
        binding.btnSum.setOnClickListener(View.OnClickListener {
            val intent =Intent(this,Addition::class.java)
            intent.putExtra("num1",binding.txtNum1.text.toString().toInt())
            intent.putExtra("num2",binding.txtNum2.text.toString().toInt())
            startService(intent)

        })

    }
    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    fun onEvent(result:ResultData){
        binding.txtResult.text="Sum of two number="+result.sum
    }
    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

}
