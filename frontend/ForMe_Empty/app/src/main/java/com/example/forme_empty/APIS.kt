package com.example.forme_empty

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIS {

    @GET("/api/main/1")
    @Headers("accept: application/json",
        "content-type: application/json")
    fun get_users(): Call<HTTP_GET_Model>


    companion object{

        //private const val BASE_URL = "https://eunproject.herokuapp.com/"//주소
        private const val BASE_URL = "http://34.64.206.224:8080"//주소


        fun create(): APIS {

            val gson: Gson = GsonBuilder().setLenient().create();

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIS::class.java)
        }
    }

}