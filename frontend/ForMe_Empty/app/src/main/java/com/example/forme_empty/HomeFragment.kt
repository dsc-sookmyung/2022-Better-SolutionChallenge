 package com.example.forme_empty

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forme_empty.adapter.RecordItemAdapter
import com.example.forme_empty.data.RecommendDatasource
import com.example.forme_empty.data.RecordDatasource

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
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    //onViewCreated구현
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recordRecyclerView.setHasFixedSize(true) //lazy접근
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
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