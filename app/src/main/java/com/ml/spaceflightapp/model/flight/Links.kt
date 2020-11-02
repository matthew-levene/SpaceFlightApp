package com.ml.spaceflightapp.model.flight

import com.google.gson.annotations.SerializedName

/**
 * This class provides access to media related to the flight
 */
data class Links (
	@SerializedName("badge") val badge : Badge,
	@SerializedName("presskit") val presskit : String,
	@SerializedName("webcast") val webcast : String,
	@SerializedName("youtube_id") val youtube_id : String,
	@SerializedName("article") val article : String,
	@SerializedName("wikipedia") val wikipedia : String
)
