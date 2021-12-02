package edu.kiet.fcmmessage

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.greenrobot.eventbus.EventBus

class FCMService: FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.d("FCMToken", "Refreshed token: $token")

    }
    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            Log.d("FCMToken", "Message data payload: ${remoteMessage.data}")

        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d("FCMToken", "Message Notification Body: ${it.body}")
            EventBus.getDefault().post(FCMMessage(it.body.toString()))
        }

    }
}