package com.ml.spaceflightapp.util

import android.app.Application
import com.ml.spaceflightapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SpaceFlightApp : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin(){
        startKoin {
            androidContext(this@SpaceFlightApp)
            androidLogger(Level.ERROR)
            modules(netModule, apiModule, databaseModule, repoModule, viewModelModule)
        }
    }
}