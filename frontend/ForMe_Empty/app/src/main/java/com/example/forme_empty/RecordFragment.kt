package com.example.forme_empty

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forme_empty.adapter.RecordItemAdapter
import com.example.forme_empty.adapter.RecordPageAdapter
import com.example.forme_empty.data.RecordDatasource
import com.example.forme_empty.data.RecordPageDatasource

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecordFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    // 1. Context를 받아올 변수 선언
    lateinit var mainActivity: MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)

        // 2. Context를 Activity로 형변환하여 할당
        mainActivity = context as MainActivity

    }



    private val recordRecyclerView: RecyclerView by lazy {
        view?.findViewById(R.id.record_recycler_view) as RecyclerView
    }
    val recordList = RecordPageDatasource().loadRecord()
    private lateinit var adapterRecord: RecordPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

/*
        //1. 레이아웃을 inflate()하여 view를 변수에 저장
        val view = inflater.inflate(R.layout.fragment_record, container, false)
        //2. view객체에서 findViewById()메서드 호출
        val intent = Intent(getActivity(), WriteRecord::class.java)
        val recordRegisterButton: Button = view.findViewById<Button>(R.id.record_button)
        recordRegisterButton.setOnClickListener {
            startActivity(intent)
        }
*/

        return inflater.inflate(R.layout.fragment_record, container, false)
    }

    override fun onStart() {
        super.onStart()

    //Button참조해서 리스너 달기
        val recordRegisterButton = mainActivity.findViewById<Button>(R.id.record_button)
        val intent = Intent(getActivity(), WriteRecord::class.java)
        recordRegisterButton.setOnClickListener {
            startActivity(intent)
        }
    }
    //onViewCreated구현
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recordRecyclerView.setHasFixedSize(true) //lazy접근
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            recordRecyclerView.layoutManager = LinearLayoutManager(context)
            //.also { it.orientation = LinearLayoutManager.HORIZONTAL }
        }
        val mainViewAdapter = RecordPageAdapter(requireContext(), recordList)
        //성능을 개선하기 위해 다음을 설정
        //레이아웃의 크기가 변경되지 않는 경우!에 설정
        //recordRecyclerView.setHasFixedSize(true)


        recordRecyclerView.apply {
            this.adapter = mainViewAdapter
            setHasFixedSize(true)

            val verticalLayout = LinearLayoutManager(context)
            verticalLayout.orientation = LinearLayoutManager.VERTICAL
            layoutManager = verticalLayout

        }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecordFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

/*
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val record_button = Button.findViewById(R.id.record_button)


    }
*/
}