package com.d121211086.Minuman.main

import android.app.Application
import  com.d121211086.Minuman.data.AppContainer
import  com.d121211086.Minuman.data.DefaultAppContainer

class MyApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}