package com.example.forme_empty

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //알람설정
/*
        var builder = NotificationCompat.Builder(this, "MY_channel")
            .setSmallIcon(R.drawable.toma)
            .setContentTitle("알림 제목")
            .setContentText("알림 내용")

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.0) {
            val channel_id = "My_channel"
            val channel_name = "채널이름"
            val descriptionText = "설명글"//채널 설명글 설정
            val importance = NotificationManager.IMPORTANCE_DEFAULT//알림 우선순위 설정
            val channel = NotificationChannel(channel_id, channel_name, importance).apply {
                description = descriptionText
            }

            //만든 채널 정보를 시스템에 등록
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            //알림 표시 : 알림 고유 ID, 알림 결과
            notificationManager.notify(1002, builder.build())
        }
*/

        //음식기록페이지로 이동하기 위한 인덴트 생성
/*
        val registrationIntent = Intent(this, WriteRecord::class.java)
        val RegisterPageButton: Button = findViewById(R.id.record_button)
        RegisterPageButton.setOnClickListener {
            startActivity(registrationIntent)
        }
*/

        /*
        *바텀바
         */
        // 하단 탭이 눌렸을 때 화면을 전환하기 위해선 이벤트 처리하기 위해 BottomNavigationView 객체 생성
        var bnv_main = findViewById(R.id.bnv_main) as BottomNavigationView

        // OnNavigationItemSelectedListener를 통해 탭 아이템 선택 시 이벤트를 처리
        // navi_menu.xml 에서 설정했던 각 아이템들의 id를 통해 알맞은 프래그먼트로 변경하게 한다.
        bnv_main.run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.first -> {
                        // 다른 프래그먼트 화면으로 이동하는 기능
                        val homeFragment = HomeFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_container, homeFragment).commit()
                    }
                    R.id.second -> {
                        val recommendFragment = RecommendFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_container, recommendFragment).commit()
                    }
                    R.id.third -> {
                        val recordFragment = RecordFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_container, recordFragment).commit()
                    }
                    R.id.fourth -> {
                        val myFragment = MyFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_container, myFragment).commit()
                    }
                }
                true
            }
            selectedItemId = R.id.first
        }




    }
}