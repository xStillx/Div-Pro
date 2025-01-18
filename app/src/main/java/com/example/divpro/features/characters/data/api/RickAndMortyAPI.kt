package com.example.divpro.features.characters.data.api

import com.example.divpro.features.characters.data.model.CharacterResponse
import retrofit2.http.GET

interface RickAndMortyAPI {

    @GET("character")
    suspend fun getCharacter(): CharacterResponse

}