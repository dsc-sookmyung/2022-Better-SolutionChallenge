package com.example.forme_empty.data

import com.example.forme_empty.R
import com.example.forme_empty.model.ForMe

class RecordPageDatasource {

    fun loadRecord(): List<ForMe> {
        return listOf<ForMe>(
            ForMe(R.string.record_text1, R.drawable.record1,),
            ForMe(R.string.record_text2, R.drawable.record2),
            ForMe(R.string.record_text3, R.drawable.record3),
            ForMe(R.string.record_text4, R.drawable.record4),
            ForMe(R.string.record_text5, R.drawable.record5) )
    }

}