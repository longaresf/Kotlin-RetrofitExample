package com.example.retrofitexample_0

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MarsViewModel : ViewModel() {


    private val repository: MarsRepository
    val liveDataFromInternet: LiveData<List<MarsRealState>>

    init {

        repository = MarsRepository()
        liveDataFromInternet = repository.fetchDataMars()
    }
}