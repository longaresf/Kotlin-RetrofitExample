package com.example.retrofitexample_0

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsRepository {

    private val retrofitClient = RetrofitClient.getRetrofit()
    val dataFromInternet = MutableLiveData<List<MarsRealState>>()

    fun fetchDataMars(): LiveData<List<MarsRealState>> {  // Vieja confiable
        Log.d("REPO", "VIEJA CONFIABLE")
        retrofitClient.fetchMarsData().enqueue(object : Callback<List<MarsRealState>> {
            override fun onResponse(
                call: Call<List<MarsRealState>>,
                response: Response<List<MarsRealState>>
            ) {
                when (response.code()) {
                    in 200..299 -> dataFromInternet.value = response.body()
                    in 300..301 -> Log.d("REPO", "${response.code()} --- ${response.errorBody()}")
                    else -> Log.d(
                        "REPO",
                        "${response.code()} --- ${response.errorBody().toString()}"
                    )
                }
            }

            override fun onFailure(call: Call<List<MarsRealState>>, t: Throwable) {
                Log.e("REPO", "${t.message}")
            }
        })
        return dataFromInternet
    }
}