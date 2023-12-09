package com.example.birdseyeview_part2.apiService

import com.example.birdseyeview_part2.model.Bird
import com.example.birdseyeview_part2.model.Birds
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BirdsAPIService {
    @GET("recordings?")
    suspend fun getBirdsNames(@Query("query") country: String): Response<Birds>

}