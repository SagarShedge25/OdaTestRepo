package com.oda.odaassignment.data

/**Created by srshe on 18-February-2022**/
class DefaultTasksRepository constructor(private val retrofitService: ComponentApiService = RemoteInjector.injectComponentApiService()) {

    suspend fun getComponents() = retrofitService.getComponents()

}