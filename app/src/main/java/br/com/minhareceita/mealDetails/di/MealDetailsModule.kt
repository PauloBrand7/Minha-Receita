package br.com.minhareceita.mealDetails.di

import br.com.minhareceita.mealDetails.data.api.MealDetailsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object MealDetailsModule {

    @Provides
    fun provideClient(retrofit: Retrofit): MealDetailsAPI =
        retrofit.create(MealDetailsAPI::class.java)
}