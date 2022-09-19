package br.com.minhareceita.recipe.di

import br.com.minhareceita.recipe.data.api.RecipeAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object RecipeModule {

    @Provides
    fun provideClient(retrofit: Retrofit): RecipeAPI =
        retrofit.create(RecipeAPI::class.java)
}