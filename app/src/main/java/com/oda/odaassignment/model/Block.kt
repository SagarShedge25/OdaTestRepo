package com.oda.odaassignment.model

import com.google.gson.annotations.SerializedName

/**Created by srshe on 18-February-2022**/
class Block {
    @SerializedName("blocks") var blocks : List<Component?> = arrayListOf()
}