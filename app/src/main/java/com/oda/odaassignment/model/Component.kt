package com.oda.odaassignment.model

import com.google.gson.annotations.SerializedName

/**Created by srshe on 18-February-2022**/
class Component {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("component")
    var component: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("button")
    var button: Button? = Button()
    @SerializedName("tracking_properties")
    var trackingProperties: TrackingProperties? = TrackingProperties()
    @SerializedName("products")
    var products: ArrayList<Product> = arrayListOf()
}