package com.example.registerloginpage.data

import com.example.registerloginpage.model.ForMe
import com.example.registerloginpage.R


data class RecommendDatasource(var recipe: String) {
    fun loadRecommend(): List<ForMe> {
        return listOf<ForMe>(ForMe(R.string.recommend1, R.drawable.recommend1),
            ForMe(R.string.recommend2, R.drawable.recommend2),
            ForMe(R.string.recommend3, R.drawable.recommend3),
            ForMe(R.string.recommend4, R.drawable.recommend4),
            ForMe(R.string.recommend5, R.drawable.recommend5) )
    }
}