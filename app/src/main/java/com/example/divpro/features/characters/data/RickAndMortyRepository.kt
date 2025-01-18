package com.example.divpro.features.characters.data

import com.example.divpro.features.characters.data.api.RickAndMortyAPI
import com.example.divpro.features.characters.data.model.mapper.CharacterMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(
    private val api: RickAndMortyAPI,
    private val characterMapper: CharacterMapper
) {

    suspend fun getCharacter() = withContext(Dispatchers.IO){
        api.getCharacter().let {
            characterMapper.map(it)
        }
    }
}