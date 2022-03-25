package com.example.forme_empty

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class PushActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push)
        //푸쉬알림을 위한 선언
        val notificationId : Int = 1002
        //val CHANNEL_ID = "MyChannel"

        //main페이지로 이동하기 위한 인덴트 생성
        val mainIntent = Intent(this, MainActivity::class.java)
        val backButton: Button = findViewById(R.id.back)
        backButton.setOnClickListener {
            startActivity(mainIntent)
        }

        var button = findViewById<Button>(R.id.button) as Button
        button.setOnClickListener {

/*
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
*/

            var builder = NotificationCompat.Builder(this, "MyChannel")//CHANNEL_ID)
                .setSmallIcon(R.drawable.toma)
                .setContentTitle("오늘은 채식 목표의 날이에요")
                .setContentText("이번 주도 힘내봅시다!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                //.setContentIntent(pendingIntent)
                .setAutoCancel(true)

            if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //val channel_id = "My_channel"
                val channel_name = "채널이름"
                val descriptionText = "설명글"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("MyChannel", channel_name, importance).apply {
                    description = descriptionText
                }

                //만든 채널 정보를 시스템에 등록
                val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
                //알림 표시 : 알림 고유 ID (1002), 알림 결과
                //notificationManager.notify(1002, builder.build())

                with(NotificationManagerCompat.from(this)) {
                    notify(notificationId, builder.build())
                }

        }
        }

    }
}