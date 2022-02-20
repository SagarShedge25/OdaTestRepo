package com.oda.odaassignment.model

import com.google.gson.annotations.SerializedName

/**Created by srshe on 18-February-2022**/
class Button {
    @SerializedName("title")
    var title: String? = null
    @SerializedName("target")
    var target: Target? = Target()
}