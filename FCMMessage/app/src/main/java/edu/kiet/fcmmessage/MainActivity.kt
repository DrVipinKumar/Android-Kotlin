package edu.kiet.fcmmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import edu.kiet.fcmmessage.databinding.ActivityMainBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.ThreadMode

import org.greenrobot.eventbus.Subscribe







class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        EventBus.getDefault().register(this)
        binding.fcmMsg=FCMMessage("Message will be replace here")
        binding.lifecycleOwner=this
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    fun onEvent(fcmMessage: FCMMessage) {
        binding.fcmMsg=fcmMessage
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}