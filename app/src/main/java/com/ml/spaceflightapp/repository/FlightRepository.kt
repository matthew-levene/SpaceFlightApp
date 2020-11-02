package com.ml.spaceflightapp.repository

import android.util.Log
import com.ml.spaceflightapp.model.db.FlightDao
import com.ml.spaceflightapp.model.flight.FlightResponse
import com.ml.spaceflightapp.model.network.FlightApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/**
 * Class is used to communicate with the API and local Room database
 */
class FlightRepository(
    private val flightDao: FlightDao,
    private val flightApiService: FlightApiService
) {

    /**
     * Function retrieves flight data from the API services and caches it to a local
     * Room database
     */
    suspend fun getFlights() {
        withContext(Dispatchers.IO) {
            try {
                val flightData = flightApiService.getAllFlights().await()
                storeFlightData(FlightResponse(1, flightData))
            } catch (exception: HttpException) {
                Log.d("HTTP-EX", exception.message())
            }
        }
    }

    /**
     * Save FlightResponse data to local database
     * @param flightResponse
     */
    fun storeFlightData(flightResponse: FlightResponse) {
        flightDao.insertFlights(flightResponse)
    }

    /**
     * Listen for changes in the FlightResponse table and reports them to any registered
     * ViewModel classes
     */
    val flightData = flightDao.getAllFlights()
}

