package com.example.buildjetpackcomposeapplicationexamples.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buildjetpackcomposeapplicationexamples.Data.Models.FirstApiResponseModel
import com.example.buildjetpackcomposeapplicationexamples.Data.Models.FirstApiResponseModelItem
import com.example.buildjetpackcomposeapplicationexamples.Data.Repository.ApiRepository
import com.example.buildjetpackcomposeapplicationexamples.Utils.ApiResponse
import com.example.buildjetpackcomposeapplicationexamples.Utils.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val mutableSharedFlow = MutableStateFlow<ApiResponse<List<FirstApiResponseModelItem>>>(ApiResponse.IdleState)
    val fetchValue: StateFlow<ApiResponse<List<FirstApiResponseModelItem>>> = mutableSharedFlow

    fun callFirstApiFromRepo() {
        viewModelScope.launch {
            mutableSharedFlow.value = ApiResponse.Loading
            RetrofitInstance.apiRepositoryInstance.getFirstApiResponse().catch { error->
                mutableSharedFlow.value = ApiResponse.Error(error.toString())
            }.collect { response ->
                mutableSharedFlow.value = ApiResponse.Success(response)
            }
        }
    }
}