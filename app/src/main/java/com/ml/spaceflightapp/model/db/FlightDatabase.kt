package com.ml.spaceflightapp.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ml.spaceflightapp.model.db.DatabaseConstants.EXPORT_SCHEMA
import com.ml.spaceflightapp.model.db.DatabaseConstants.FLIGHT_DATABASE_VERSION
import com.ml.spaceflightapp.model.flight.FlightResponse

@Database(entities = [FlightResponse::class], version = FLIGHT_DATABASE_VERSION, exportSchema = EXPORT_SCHEMA)
@TypeConverters(Converters::class)
abstract class FlightDatabase : RoomDatabase() {
    abstract val flightDao: FlightDao
}