package com.example.forme_empty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        *리사이클러뷰
        */


/*
        val recordDataset = RecordDatasource().loadRecord()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = RecordItemAdapter(this, recordDataset)

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.HORIZONTAL
*/
/*
        recordRecyclerView.layoutManager = llm
        recordRecyclerView.adapter = RecordItemAdapter(this, recordDataset)
*//*



//        recordRecyclerView.adapter = RecordItemAdapter(this, recordDataset)

        //성능을 개선하기 위해 다음을 설정
        //레이아웃의 크기가 변경되지 않는 경우!에 설정
        //recordRecyclerView.setHasFixedSize(true)

        //가로로 리사이클러뷰를 만들기 위한 코드

*/
/*
        recordRecyclerView.layoutManager =
            LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
*//*



        //중복스크롤에 따른 오류 방지
        //recordRecyclerView.setNestedScrollingEnabled(false);


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