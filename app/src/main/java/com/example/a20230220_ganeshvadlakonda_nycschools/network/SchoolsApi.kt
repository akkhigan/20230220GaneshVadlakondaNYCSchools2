package com.example.a20230220_ganeshvadlakonda_nycschools.network

import com.example.a20230220_ganeshvadlakonda_nycschools.models.School
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface SchoolsApi {

 @GET("DOE-High-School-Directory-2017/s3k6-pzi2")
 suspend fun getSchoolsList() : Response<List<School>>

 @GET("SAT-Results/f9bf-2cp4")
 suspend fun getSchoolDetails() : Response<String>

 companion object{
  operator fun  invoke(): SchoolsApi{
   val Base_URL = "https://data.cityofnewyork.us/Education/"
   val gson = GsonBuilder()
       .setLenient()
       .create()

   return Retrofit.Builder()
         .addConverterFactory(GsonConverterFactory.create(gson))
         .baseUrl(Base_URL)
         .build()
         .create(SchoolsApi::class.java)
  }
 }
}