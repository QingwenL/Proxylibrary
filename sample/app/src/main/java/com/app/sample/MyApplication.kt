package com.example

import android.app.Application

import com.proxylib.Proxylibrary
import com.squareup.leakcanary.LeakCanary

/**
 * Created by 2017/7/21
 * @author: Liqingwen
 */
class MyApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        // 初始化LeakCanary
        LeakCanary.install(this)
        Proxylibrary.init(this)
    }

}
