package br.com.minhareceita.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitClient {

    private val BASE_URL = "www.themealdb.com/api/json/v1/1"
    private val okHttpClient = OkHttpClient
        .Builder()
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    fun getClient(): ReceiptsAPI {
        return retrofit.create(ReceiptsAPI:: class.java)
    }
}