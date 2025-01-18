package com.example.divpro.features.characters.di

import com.example.divpro.features.characters.data.api.RickAndMortyAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class CharactersFeatureModule {

    @Provides
    fun provideCharacterApi(retrofit: Retrofit) = retrofit.create(
        RickAndMortyAPI::class.java
    )
}