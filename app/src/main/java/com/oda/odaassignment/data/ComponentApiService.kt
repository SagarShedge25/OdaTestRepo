package com.oda.odaassignment.data

import com.oda.odaassignment.model.Block
import retrofit2.Response
import retrofit2.http.GET

/**Created by srshe on 19-February-2022**/
interface ComponentApiService {

    @GET("getResponseJson")
    suspend fun getComponents(): Response<Block>

}