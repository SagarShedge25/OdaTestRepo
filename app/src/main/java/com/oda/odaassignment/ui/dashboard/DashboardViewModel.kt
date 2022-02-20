package com.oda.odaassignment.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oda.odaassignment.data.DefaultTasksRepository
import com.oda.odaassignment.model.Block
import kotlinx.coroutines.*
import kotlinx.coroutines.launch


class DashboardViewModel constructor(private val defaultTasksRepository: DefaultTasksRepository) : ViewModel() {

    val blocks  = MutableLiveData<Block>()
    var job: Job? = SupervisorJob()

    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        viewModelScope.launch(Dispatchers.Main) {
            onError("Exception handled: ${throwable.localizedMessage}")
        }
    }
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun setBlocks() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = defaultTasksRepository.getComponents()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    blocks.value = response.body()
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}