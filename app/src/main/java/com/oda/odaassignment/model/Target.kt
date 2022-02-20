package com.oda.odaassignment.model

import com.google.gson.annotations.SerializedName

/**Created by srshe on 18-February-2022**/
class Target {
    @SerializedName("method" ) var method : String? = null
    @SerializedName("title"  ) var title  : String? = null
    @SerializedName("uri"    ) var uri    : String? = null
}