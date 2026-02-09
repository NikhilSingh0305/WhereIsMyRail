package com.example.buildjetpackcomposeapplicationexamples.Data.Models

data class LoginModel (
    var message: String ?= null,
    var token : String ?= null,
    var loginId : String ?= null,
)