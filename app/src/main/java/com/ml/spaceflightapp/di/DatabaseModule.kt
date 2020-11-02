package com.ml.spaceflightapp.di

import android.app.Application
import androidx.room.Room
import com.ml.spaceflightapp.model.db.DatabaseConstants.FLIGHT_DATABASE_NAME
import com.ml.spaceflightapp.model.db.FlightDao
import com.ml.spaceflightapp.model.db.FlightDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application) : FlightDatabase {
        return Room.databaseBuilder(application, FlightDatabase::class.java, FLIGHT_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: FlightDatabase) : FlightDao {
        return database.flightDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}