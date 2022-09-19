package br.com.minhareceita.recipe.di

import br.com.minhareceita.recipe.data.api.RecipeAPI
import dagger.Provides
import retrofit2.Retrofit

object RecipeModule {

    @Provides
    fun provideClient(retrofit: Retrofit): RecipeAPI =
        retrofit.create(RecipeAPI::class.java)
}