package br.com.minhareceita.data.network.api

import br.com.minhareceita.Application
import br.com.minhareceita.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(Application::class)
object RetrofitClient {

    @Singleton
    private val okHttpClient = OkHttpClient
        .Builder()
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun getClient(): MealAPI {
        return retrofit.create(MealAPI::class.java)
    }
}