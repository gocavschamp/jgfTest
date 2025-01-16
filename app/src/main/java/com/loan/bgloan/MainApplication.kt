package com.loan.bgloan

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)

    }
}