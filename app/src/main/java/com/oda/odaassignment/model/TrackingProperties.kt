package com.oda.odaassignment.model

import com.google.gson.annotations.SerializedName

/**Created by srshe on 18-February-2022**/
class TrackingProperties {
    @SerializedName("location"  ) var location : String? = null
    @SerializedName("list_name" ) var listName : String? = null
}