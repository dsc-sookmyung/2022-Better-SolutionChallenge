package com.example.registerloginpage.data

import com.example.registerloginpage.model.ForMe
import com.example.registerloginpage.R

class RecordDatasource {
    fun loadRecord(): List<ForMe> {
        return listOf<ForMe>(ForMe(R.string.record1, R.drawable.record1),
            ForMe(R.string.record2, R.drawable.record2),
            ForMe(R.string.record3, R.drawable.record3),
            ForMe(R.string.record4, R.drawable.record4),
            ForMe(R.string.record5, R.drawable.record5) )
    }
}