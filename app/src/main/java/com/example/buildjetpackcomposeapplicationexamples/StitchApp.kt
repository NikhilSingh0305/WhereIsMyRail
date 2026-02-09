package com.example.buildjetpackcomposeapplicationexamples

import android.app.Application
import android.util.Log

class StitchApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("nik", "onCreate: ApplicationLayerIsCalled" )
    }

}