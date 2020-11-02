package com.ml.spaceflightapp.model.network

import com.ml.spaceflightapp.model.flight.Flight
import com.ml.spaceflightapp.model.network.NetworkConstants.FLIGHT_DATA_ENDPOINT
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 *  Interface provides access to the Space X API Service
 */
interface  FlightApiService {

    /**
     * Function retrieves a list of flights launched by SpaceX
     * @return List of Flight objects
     */
    @GET(FLIGHT_DATA_ENDPOINT)
    fun getAllFlights() : Deferred<List<Flight>>
}