package br.com.minhareceita.category.di

import br.com.minhareceita.category.data.api.MealCategoryAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object CategoryModule {
    @Provides
    fun provideClient(retrofit: Retrofit): MealCategoryAPI =
        retrofit.create(MealCategoryAPI::class.java)
}