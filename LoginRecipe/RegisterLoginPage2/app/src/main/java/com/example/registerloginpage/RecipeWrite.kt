package com.example.registerloginpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registerloginpage.adapter.RecommendItemAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_recipe_write.newInstance] factory method to
 * create an instance of this fragment.
 */

class RecipeWrite : AppCompatActivity() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_recipe_write)

        //변수선언
        val recipe_class = findViewById<Spinner>(R.id.recipe_class)
        val recipe_write_back = findViewById<Button>(R.id.recipe_write_back)
        val recipe_image_button = findViewById<Button>(R.id.recipe_image_button)
        val recipe_add = findViewById<Button>(R.id.recipe_add)
        val recipe_image_add = findViewById<Button>(R.id.recipe_image_add)
        val recipe_save = findViewById<Button>(R.id.recipe_save)
        val recipe_recycler = findViewById<RecyclerView>(R.id.recipe_recycler)
        //val recipe_adapter = findViewById<Adapter>(R.id.)

        //어댑터 연결
        recipe_class.adapter = ArrayAdapter.createFromResource(
            this, R.array.vegan_level, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            recipe_class.adapter = adapter
        }

        recipe_recycler.apply {
            this.adapter = RecommendItemAdapter
            setHasFixedSize(true)
            val horizontalLayout = LinearLayoutManager(context)
            horizontalLayout.orientation = LinearLayoutManager.HORIZONTAL
            layoutManager = horizontalLayout

            //리스너
            recipe_class.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    TODO("Not yet implemented")
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

            recipe_write_back.setOnClickListener {

            }

            recipe_image_button.setOnClickListener {

            }

            recipe_add.setOnClickListener {

            }

            recipe_image_add.setOnClickListener {

            }

            recipe_save.setOnClickListener {

            }

        }
    }

}