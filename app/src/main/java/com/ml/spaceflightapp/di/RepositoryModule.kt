package com.ml.spaceflightapp.di

import com.ml.spaceflightapp.model.db.FlightDao
import com.ml.spaceflightapp.model.network.FlightApiService
import com.ml.spaceflightapp.repository.FlightRepository
import org.koin.dsl.module

val repoModule = module {
    fun provideRepository(dao: FlightDao,apiService: FlightApiService) : FlightRepository {
        return FlightRepository(dao, apiService)
    }

    single { provideRepository(get(), get()) }
}