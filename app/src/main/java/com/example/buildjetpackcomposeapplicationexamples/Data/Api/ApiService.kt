package com.example.buildjetpackcomposeapplicationexamples.Data.Api

import com.example.buildjetpackcomposeapplicationexamples.Data.Models.FirstApiResponseModel
import com.example.buildjetpackcomposeapplicationexamples.Data.Models.FirstApiResponseModelItem
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    suspend fun getFirstApiCall() : List<FirstApiResponseModelItem>

}