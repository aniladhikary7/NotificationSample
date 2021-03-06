package com.anil.notificationsample

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App: Application(){

    companion object{
        const val CHANNEL_1_ID = "channel1"
        const val CHANNEL_2_ID = "channel2"
    }
    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel1 = NotificationChannel(CHANNEL_1_ID,
                "channel 1",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description = "This is channel 1"

            val channel2 = NotificationChannel(CHANNEL_2_ID,
                "channel 2",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel2.description = "This is channel 2"

            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel1)
            manager.createNotificationChannel(channel2)
        }
    }
}