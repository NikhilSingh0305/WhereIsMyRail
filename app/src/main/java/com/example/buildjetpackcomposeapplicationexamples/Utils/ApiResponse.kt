package com.example.buildjetpackcomposeapplicationexamples.Utils

sealed class ApiResponse<out T> {
    class Success<T> (val data : T) : ApiResponse<T>()
    class Error (val message : String) : ApiResponse<Nothing>()
    object Loading  : ApiResponse<Nothing>()
    object IdleState  : ApiResponse<Nothing>()
}
