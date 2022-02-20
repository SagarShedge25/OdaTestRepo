package com.oda.odaassignment.model

import com.google.gson.annotations.SerializedName

/**Created by srshe on 18-February-2022**/
class Availability {
    @SerializedName("is_available")
    var isAvailable: Boolean? = null
    @SerializedName("code")
    var code: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("description_short")
    var descriptionShort: String? = null
}