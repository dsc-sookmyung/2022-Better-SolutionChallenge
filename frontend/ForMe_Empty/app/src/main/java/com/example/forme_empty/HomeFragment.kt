 package com.example.forme_empty

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forme_empty.adapter.RecordItemAdapter
import com.example.forme_empty.data.RecommendDatasource
import com.example.forme_empty.data.RecordDatasource
import com.example.forme_empty.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.expm1

 // TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters




    //레트로핏
    val api = APIS.create()
    val binding by lazy { com.example.forme_empty.databinding.FragmentHomeBinding.inflate(layoutInflater) }

    var retrofitText : String? = null

    private var param1: String? = null
    private var param2: String? = null

    private val recordRecyclerView: RecyclerView by lazy {
        view?.findViewById(R.id.recycler_view) as RecyclerView
    }
    private val recommendRecyclerView: RecyclerView by lazy {
        view?.findViewById(R.id.recommend_recycler_view) as RecyclerView
    }
    val recordList = RecordDatasource().loadRecord()
    val recommendList = RecommendDatasource().loadRecommend()
    private lateinit var adapterRecord: RecordItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        //알람설정
/*
        var alram = binding.alram
        alram.setOnClickListener {
            var builder = NotificationCompat.Builder(this, "MY_channel")
                .setSmallIcon(R.drawable.toma)
                .setContentTitle("알림 제목")
                .setContentText("알림 내용")

            if (Build.VERSION.SDK_INT >= VERSION_CODES .0) {
            val channel_id = "My_channel"
            val channel_name = "채널이름"
            val descriptionText = "설명글"//채널 설명글 설정
            val importance = NotificationManager.IMPORTANCE_DEFAULT//알림 우선순위 설정
            val channel = NotificationChannel(channel_id, channel_name, importance).apply {
                description = descriptionText
            }

            //만든 채널 정보를 시스템에 등록
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            //알림 표시 : 알림 고유 ID, 알림 결과
            notificationManager.notify(1002, builder.build())
        }

        }

 */


        //binding.retrofit.setOnClickListener {
            api.get_users().enqueue(object : Callback<HTTP_GET_Model> {
                override fun onResponse(
                    call: Call<HTTP_GET_Model>,
                    response: Response<HTTP_GET_Model>
                ) {
                    Log.d("log", response.toString())
                    Log.d("log", response.body().toString())
                    if (!response.body().toString().isEmpty()) {
                        //binding.text.setText(response.body().toString())

                        //다른 텍스트 바꿔보기
/*
                    retrofitText = response.body().toString()
                    binding.textHome1.setText("매주 "+retrofitText[])
                    }
*/

                        //DataModel의 변수 그대로 이용하기
                        //text_home1 - day1
                        var dayOfWeek : String
                        dayOfWeek = when (response.body()?.day1) {
                            0 -> "월요일"
                            1 -> "화요일"
                            2 -> "수요일"
                            3 -> "목요일"
                            4 -> "금요일"
                            5 -> "토요일"
                            6 -> "일요일"
                            else -> ""
                        }
                        binding.textHome1.setText("· 매주 "+ dayOfWeek + "은 채식 요일입니다.")


                        var goal : String
                        goal = when (response.body()?.goalType) {
                            0 -> "고기 양 줄이기"
                            1 -> "플렉시테리언"
                            2 -> "플로 베지테리언"
                            3 -> "페스코 베지테리언"
                            4 -> "락토 오보 베지테리언"
                            5 -> "오보 베지테리언"
                            6 -> "락토 베지테리언"
                            7 -> "비건"
                            else -> ""
                        }
                        binding.textHome2.setText("· 목표는 " + goal + "이군요!")


                        var level : Int
                        level = response.body()?.level!!
                        binding.nowLevel.setText(level.toString())

                        var exp : Int
                        exp = response.body()?.exp!!
                        binding.nowExp.setText(exp.toString())

                    }

                }

                override fun onFailure(call: Call<HTTP_GET_Model>, t: Throwable) {
                    Log.d("log", t.message.toString())
                    Log.d("log", "fail")
                }
            })
        }

    //}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



/*
        binding.retrofit.setOnClickListener {
            api.get_users().enqueue(object : Callback<HTTP_GET_Model> {
                override fun onResponse(
                    call: Call<HTTP_GET_Model>,
                    response: Response<HTTP_GET_Model>
                ) {
                    Log.d("log", response.toString())
                    Log.d("log", response.body().toString())
                    if (!response.body().toString().isEmpty())
                        binding.text.setText(response.body().toString())
                    else
                        binding.text.setText("연결은 성공")
                }

                override fun onFailure(call: Call<HTTP_GET_Model>, t: Throwable) {
                    Log.d("log", t.message.toString())
                    Log.d("log", "fail")
                }
            })
        }
*/

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        return binding.root
    }

    //onViewCreated구현
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recordRecyclerView.setHasFixedSize(true) //lazy접근
        if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
            recordRecyclerView.layoutManager = LinearLayoutManager(context)
            //.also { it.orientation = LinearLayoutManager.HORIZONTAL }
        }
        val mainViewAdapter = RecordItemAdapter(requireContext(), recordList)
        //성능을 개선하기 위해 다음을 설정
        //레이아웃의 크기가 변경되지 않는 경우!에 설정
        recordRecyclerView.setHasFixedSize(true)


        recordRecyclerView.apply {
            this.adapter = mainViewAdapter
            setHasFixedSize(true)
            val horizontalLayout = LinearLayoutManager(context)
            horizontalLayout.orientation = LinearLayoutManager.HORIZONTAL
            layoutManager = horizontalLayout
/*
            val gridlayout = GridLayoutManager(context, 1)
            layoutManager = gridlayout
*/

        }

        recommendRecyclerView.setHasFixedSize(true) //lazy접근
        if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
            recommendRecyclerView.layoutManager = LinearLayoutManager(context)
            //.also { it.orientation = LinearLayoutManager.HORIZONTAL }
        }
        val recommendViewAdapter = RecordItemAdapter(requireContext(), recommendList)
        //성능을 개선하기 위해 다음을 설정
        //레이아웃의 크기가 변경되지 않는 경우!에 설정
        recommendRecyclerView.setHasFixedSize(true)


        recommendRecyclerView.apply {
            this.adapter = recommendViewAdapter
            setHasFixedSize(true)
            val horizontalLayout = LinearLayoutManager(context)
            horizontalLayout.orientation = LinearLayoutManager.HORIZONTAL
            layoutManager = horizontalLayout
/*
            val gridlayout = GridLayoutManager(context, 1)
            layoutManager = gridlayout
*/

            /*
            recyclerView.apply {
                this.adapterRecord =
            }*/
        }

        //companion object {
        //companion
        //companion object{
        object {
            /**
             * Use this factory method to create a new instance of
             * this fragment using the provided parameters.
             *
             * @param param1 Parameter 1.
             * @param param2 Parameter 2.
             * @return A new instance of fragment HomeFragment.
             */
            // TODO: Rename and change types and number of parameters
            //@JvmStatic
            fun newInstance(param1: String, param2: String) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
        }
    }

}




