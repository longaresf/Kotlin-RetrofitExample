package com.example.retrofitexample_0

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.POST

// Interfaz de Conexion operaciones para enviar o recibir cosas
interface MarsApi {
    @GET("realestate")
    fun fetchMarsData(): Call<List<MarsRealState>> // VIEJA CONFIABLE


    @GET("realestate")
    suspend fun fetchMarsDataCoroutine(): Response<List<MarsRealState>> // nueva Forma

    //@POST()


}