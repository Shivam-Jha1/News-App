package com.coder178.todayheadlines

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

//https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY
//https://newsapi.org/v2/everything?domains=wsj.com&apiKey=997a35f68c4b4e2a8c1e75866c9817dc=API_KEY

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "997a35f68c4b4e2a8c1e75866c9817dc"
interface NewsInterface {
    //will define ,method call here

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country:String, @Query("page")page:Int):Call<News>

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getSports(@Query("country") country:String,@Query("category") category: String, @Query("page")page:Int):Call<News>

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getBusiness(@Query("country") country:String,@Query("category") category: String, @Query("page")page:Int):Call<News>

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHealth(@Query("country") country:String,@Query("category") category: String, @Query("page")page:Int):Call<News>

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getScience(@Query("country") country:String,@Query("category") category: String, @Query("page")page:Int):Call<News>

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getTechnology(@Query("country") country:String,@Query("category") category: String, @Query("page")page:Int):Call<News>

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getEntertainment(@Query("country") country:String,@Query("category") category: String, @Query("page")page:Int):Call<News>
}

object NewsService{
    val newsInstance:NewsInterface
    init{
        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)

    }
}

//https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=997a35f68c4b4e2a8c1e75866c9817dc
//https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=997a35f68c4b4e2a8c1e75866c9817dc