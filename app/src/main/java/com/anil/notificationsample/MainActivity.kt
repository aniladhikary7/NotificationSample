package com.anil.notificationsample

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.anil.notificationsample.App.Companion.CHANNEL_1_ID
import com.anil.notificationsample.App.Companion.CHANNEL_2_ID
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var titleEt: EditText
    private lateinit var msgEt: EditText
    private lateinit var channel1Btn: Button
    private lateinit var channel2Btn: Button
    private lateinit var notificationManager: NotificationManagerCompat

    private fun initViews(){
        titleEt = findViewById(R.id.title_et)
        msgEt = findViewById(R.id.message_et)
        channel1Btn = findViewById(R.id.channel1_btn)
        channel2Btn = findViewById(R.id.channel2_btn)
        notificationManager = NotificationManagerCompat.from(this)
        channel1Btn.setOnClickListener(this)
        channel2Btn.setOnClickListener(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    override fun onClick(v: View?) {
        when (v) {
            channel1Btn -> {
                val title = titleEt.text.toString()
                val message = msgEt.text.toString()
                
                val notification = NotificationCompat.Builder(this, CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.ic_one)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build()
                notificationManager.notify(1, notification)
            }
            channel2Btn -> {
                val title = titleEt.text.toString()
                val message = msgEt.text.toString()

                val notification = NotificationCompat.Builder(this, CHANNEL_2_ID)
                        .setSmallIcon(R.drawable.ic_two)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_LOW)
                        .build()
                notificationManager.notify(2, notification)
            }
        }
    }
}