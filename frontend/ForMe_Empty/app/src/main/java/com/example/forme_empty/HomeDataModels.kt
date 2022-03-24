package com.example.forme_empty

data class HTTP_GET_Model(
/*
    var id : Int? = null,
    var title: String? = null,
    var content : String? = null,
    var check1 : Int? = null,
    var check2 : Int? = null,
    var check3 : Int? = null,
    var check4 : Int? = null,
    var check5 : Int? = null
*/
    var day1 : Int? = null,
    var dietRecords : ArrayList<DietRecord>? = null,

    var exp : Int? = null,
    var goalType : Int? = null,
    var id : Int? = null,
    var level : Int? = null,
    var likes : Int? = null,
    var main_badge1 : Int? = null,
    var recipeRecords : ArrayList<RecipeRecord>? = null
)

data class DietRecord(
    var beef_check : Boolean? = null,
    var birds_check : Boolean? = null,
    var dairy_check	: Boolean? = null,
    var date : String? = null,
    var egg_check : Boolean? = null,
    var fish_check : Boolean? = null,
    var food_desc : String? = null,
    var food_img : String? = null,
    var food_name : String? = null,
    var id : Int? = null,
    var meal_category : Int? = null,
    var pork_check : Boolean? = null
)

data class RecipeRecord (
    var cooking_time : Int? = null,
    var desc1 : String? = null,
    var desc2 : String? = null,
    var desc3 : String? = null,
    var desc4 : String? = null,
    var desc5 : String? = null,
    var id : Int? = null,
    var pic1 : String? = null,
    var pic2 : String? = null,
    var pic3 : String? = null,
    var pic4 : String? = null,
    var pic5 : String? = null,
    var recipe_name : String? = null,
    var type : Int? = null
)