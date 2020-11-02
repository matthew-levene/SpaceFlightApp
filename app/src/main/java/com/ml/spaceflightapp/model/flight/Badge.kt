package com.ml.spaceflightapp.model.flight

import com.google.gson.annotations.SerializedName

/**
 * Class is used to provide images of the flight organization's logo
 */
data class Badge (
	@SerializedName("small") val small : String,
	@SerializedName("large") val large : String
)
