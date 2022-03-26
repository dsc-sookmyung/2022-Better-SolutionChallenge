package com.example.registerloginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_register)

        //변수 선언
        val spinner_now = findViewById<Spinner>(R.id.spinner_now)
        val spinner_goal = findViewById<Spinner>(R.id.spinner_goal)
        val spinner_day = findViewById<Spinner>(R.id.spinner_day)
        val btnMove = findViewById<Button>(R.id.btnMove)
        //intent
        val mainIntent = Intent(this, HomeFragment::class.java)

        //어댑터 연결 - array.xml에 있는 아이템 목록 추가
        spinner_now.adapter = ArrayAdapter.createFromResource(
            this, R.array.vegan_level, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_now.adapter = adapter
        }

        //아이템 선택 리스너
        spinner_now.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                println("현재 비건 단계")
            }
        }

        spinner_goal.adapter = ArrayAdapter.createFromResource(
            this, R.array.vegan_level, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_goal.adapter = adapter
        }

        //아이템 선택 리스너
        spinner_goal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                println("목표 비건 단계")
            }
        }

        spinner_day.adapter = ArrayAdapter.createFromResource(
            this, R.array.weekday, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_day.adapter = adapter
        }

        //아이템 선택 리스너
        spinner_day.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                println("채식 요일")
            }
        }

        btnMove.setOnClickListener {
            startActivity(mainIntent)
        }



    }

}