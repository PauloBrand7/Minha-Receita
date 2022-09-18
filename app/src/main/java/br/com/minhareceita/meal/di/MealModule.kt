package br.com.minhareceita.meal.di

import br.com.minhareceita.meal.data.api.MealAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object MealModule {

    @Provides
    fun provideClient(retrofit: Retrofit): MealAPI =
        retrofit.create(MealAPI::class.java)
}