package com.ml.spaceflightapp.di

import com.ml.spaceflightapp.viewmodel.FlightViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
   viewModel { FlightViewModel(get()) }
}

