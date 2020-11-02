package com.ml.spaceflightapp.model.flight

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Class is used to retrieve flight data from the API
 */
@Entity
data class Flight (

	@PrimaryKey(autoGenerate = true) val flightId: Int,
	@SerializedName("fairings") val fairings : Fairings,
	@SerializedName("links") val links : Links,
	@SerializedName("static_fire_date_utc") val static_fire_date_utc : String,
	@SerializedName("static_fire_date_unix") val static_fire_date_unix : Int,
	@SerializedName("tbd") val tbd : Boolean,
	@SerializedName("net") val net : Boolean,
	@SerializedName("window") val window : Int,
	@SerializedName("rocket") val rocket : String,
	@SerializedName("success") val success : Boolean,
	@SerializedName("details") val details : String,
	@SerializedName("crew") val crew : List<String>,
	@SerializedName("ships") val ships : List<String>,
	@SerializedName("capsules") val capsules : List<String>,
	@SerializedName("payloads") val payloads : List<String>,
	@SerializedName("launchpad") val launchpad : String,
	@SerializedName("auto_update") val auto_update : Boolean,
	@SerializedName("failures") val failures : List<Failures>,
	@SerializedName("flight_number") val flight_number : Int,
	@SerializedName("name") val name : String,
	@SerializedName("date_utc") val date_utc : String,
	@SerializedName("date_unix") val date_unix : Int,
	@SerializedName("date_local") val date_local : String,
	@SerializedName("date_precision") val date_precision : String,
	@SerializedName("upcoming") val upcoming : Boolean,
	@SerializedName("cores") val cores : List<Cores>,
	@SerializedName("id") val id : String
)
