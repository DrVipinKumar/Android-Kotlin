package edu.kiet.notificationexample

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import edu.kiet.notificationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val notificationManager:NotificationManager=applicationContext.getSystemService(
            NOTIFICATION_SERVICE) as NotificationManager
        var notificationBuilder:NotificationCompat.Builder
        var notificationChannel:NotificationChannel
        binding.btnNotifyStyle.setOnClickListener(View.OnClickListener {
            val channelID:String="NoticeNormalId"
            val channelName:String="NormalNotice"
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
            {
                notificationChannel=NotificationChannel(channelID,channelName,NotificationManager.IMPORTANCE_HIGH).apply{
                    description="This is for new normal notification"}
                notificationManager.createNotificationChannel(notificationChannel)


            }
            val bigTextStyle=NotificationCompat.BigTextStyle()
            bigTextStyle.bigText("this is my exmaple to set big text in notification")
            bigTextStyle.setSummaryText("This is summary text")
            bigTextStyle.setBigContentTitle("Thi is big Content Title")
            val bigimage =BitmapFactory.decodeResource(resources,R.drawable.blub)
            notificationBuilder = NotificationCompat.Builder(applicationContext,channelID)
            notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background)
            notificationBuilder.setLargeIcon(bigimage)
            notificationBuilder.setStyle(bigTextStyle)
            notificationBuilder.setContentTitle("Normal Notice")
            notificationBuilder.setContentText("This is normal notice with latest API")
            notificationBuilder.setAutoCancel(true)
            notificationManager.notify(100,notificationBuilder.build())
        })
        binding.btnNormalNotice.setOnClickListener(View.OnClickListener {
            val channelID:String="NoticeNormalId"
            val channelName:String="NormalNotice"
              if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
              {
                  notificationChannel=NotificationChannel(channelID,channelName,NotificationManager.IMPORTANCE_HIGH).apply{
                      description="This is for new normal notification"}
                      notificationManager.createNotificationChannel(notificationChannel)


              }
            notificationBuilder = NotificationCompat.Builder(applicationContext,channelID)
            notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background)
            notificationBuilder.setContentTitle("Normal Notice")
            notificationBuilder.setContentText("This is normal notice with latest API")
            notificationBuilder.setAutoCancel(true)
            notificationManager.notify(100,notificationBuilder.build())
        })
     binding.btnActionNotice.setOnClickListener(View.OnClickListener {
         val channelID:String="NoticeActionId"
         val channelName:String="ActionNotice"
         if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
         {
             notificationChannel=NotificationChannel(channelID,channelName,NotificationManager.IMPORTANCE_HIGH).apply{
                 description="This is for new Action notification"}
             notificationManager.createNotificationChannel(notificationChannel)


         }
         val intent=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"))
         val pendingIntent=PendingIntent.getActivity(this@MainActivity,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
         val largeImage=BitmapFactory.decodeResource(resources,R.drawable.person)
         notificationBuilder = NotificationCompat.Builder(applicationContext,channelID)
         notificationBuilder.setSmallIcon(R.drawable.person)
        //notificationBuilder.addAction(R.drawable.ic_launcher_background,"Open Google",pendingIntent)
         //notificationBuilder.setContentIntent(pendingIntent)
         notificationBuilder.setContentTitle("Action Notice")
         notificationBuilder.setContentText("This is Action notice to open google")
         notificationBuilder.setAutoCancel(true)
         notificationManager.notify(100,notificationBuilder.build())
     })


    }
}