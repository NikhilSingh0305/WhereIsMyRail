package com.example.buildjetpackcomposeapplicationexamples.Data.Models

class FirstApiResponseModel : ArrayList<FirstApiResponseModelItem>()

data class FirstApiResponseModelItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)