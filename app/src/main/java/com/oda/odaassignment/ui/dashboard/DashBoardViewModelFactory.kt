package com.oda.odaassignment.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oda.odaassignment.data.DefaultTasksRepository

/**Created by srshe on 18-February-2022**/
class DashBoardViewModelFactory constructor(private val defaultTasksRepository: DefaultTasksRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            DashboardViewModel(this.defaultTasksRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}