package com.oda.odaassignment.model

import com.google.gson.annotations.SerializedName

/**Created by srshe on 18-February-2022**/
class ProductImage {

    @SerializedName("thumbnail" ) var thumbnail : Thumbnail? = Thumbnail()
    @SerializedName("large"     ) var large     : Large?     = Large()

}