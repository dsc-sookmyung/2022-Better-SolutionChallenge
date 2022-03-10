package com.example.forme_empty

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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

    }
}