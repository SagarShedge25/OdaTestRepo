package com.oda.odaassignment.model

import com.google.gson.annotations.SerializedName

/**Created by srshe on 18-February-2022**/
class Product {
    @SerializedName("id"                               ) var id                            : Int?              = null
    @SerializedName("full_name"                        ) var fullName                      : String?           = null
    @SerializedName("brand"                            ) var brand                         : String?           = null
    @SerializedName("brand_id"                         ) var brandId                       : String?           = null
    @SerializedName("name"                             ) var name                          : String?           = null
    @SerializedName("name_extra"                       ) var nameExtra                     : String?           = null
    @SerializedName("front_url"                        ) var frontUrl                      : String?           = null
    @SerializedName("absolute_url"                     ) var absoluteUrl                   : String?           = null
    @SerializedName("images"                           ) var images                        : ArrayList<ProductImage> = arrayListOf()
    @SerializedName("gross_price"                      ) var grossPrice                    : String?           = null
    @SerializedName("gross_unit_price"                 ) var grossUnitPrice                : String?           = null
    @SerializedName("unit_price_quantity_abbreviation" ) var unitPriceQuantityAbbreviation : String?           = null
    @SerializedName("unit_price_quantity_name"         ) var unitPriceQuantityName         : String?           = null
    @SerializedName("currency"                         ) var currency                      : String?           = null
    //    @SerializedName("discount"                         ) var discount                      : String?           = null
//    @SerializedName("promotion"                        ) var promotion                     : String?           = null
    @SerializedName("availability"                     ) var availability                  : Availability?     = Availability()
//    @SerializedName("client_classifiers"               ) var clientClassifiers             : ArrayList<String> = arrayListOf()
}