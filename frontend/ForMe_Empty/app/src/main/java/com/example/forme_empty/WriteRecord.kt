package com.example.forme_empty

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContentProviderCompat.requireContext
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class WriteRecord : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_record)

        var now = LocalDate.now()
        var strNow = now.format(DateTimeFormatter.ofPattern("MM/dd"))
        val dateText = findViewById<TextView>(R.id.todayDate)
        dateText.setText(strNow)

/*
        val adapter = ArrayAdapter(
            requireContext()
        ) 
*/

        //Button참조해서 리스너 달기
        //registration페이지로 이동하기 위한 인덴트 생성
        val MainActivityIntent = Intent(this, MainActivity::class.java)
        val finButton: Button = findViewById(R.id.fin_button)
        finButton.setOnClickListener {
            startActivity(MainActivityIntent)
        }

    }


}
