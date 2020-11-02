package com.ml.spaceflightapp.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ml.spaceflightapp.model.db.DatabaseConstants.DELETE_ALL_FLIGHTS_QUERY
import com.ml.spaceflightapp.model.db.DatabaseConstants.SELECT_ALL_FLIGHTS_QUERY
import com.ml.spaceflightapp.model.flight.FlightResponse

/**
 * Interface is used to perform data access operations on the FlightDatabase
 */
@Dao
interface FlightDao {

    /**
     * Insert flights into the FlightResponse table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFlights(flightResponse: FlightResponse)

    /**
     * Get all flight data from the FlightResponse table
     */
    @Query(SELECT_ALL_FLIGHTS_QUERY)
    fun getAllFlights() : LiveData<FlightResponse>

    /**
     * Delete all flight data from the FlightResponse table
     */
    @Query(DELETE_ALL_FLIGHTS_QUERY)
    fun deleteAllFlights()
}