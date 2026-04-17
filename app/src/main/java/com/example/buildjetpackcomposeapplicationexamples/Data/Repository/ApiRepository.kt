package com.example.buildjetpackcomposeapplicationexamples.Data.Repository

import com.example.buildjetpackcomposeapplicationexamples.Data.Models.FirstApiResponseModel
import com.example.buildjetpackcomposeapplicationexamples.Data.Models.FirstApiResponseModelItem
import com.example.buildjetpackcomposeapplicationexamples.Utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ApiRepository {
    fun getFirstApiResponse(): Flow<List<FirstApiResponseModelItem>> = flow {
        val callingApiRepoFunction = RetrofitInstance.api.getFirstApiCall()
        emit(callingApiRepoFunction)
    }.flowOn(Dispatchers.IO)
}