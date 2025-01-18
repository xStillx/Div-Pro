package com.example.divpro.features.characters.domain

import com.example.divpro.features.characters.data.RickAndMortyRepository
import com.example.divpro.utils.safeRequest
import javax.inject.Inject

class CharacterInteractor @Inject constructor(
    private val repository: RickAndMortyRepository
) {

    suspend fun getCharacter() = safeRequest {
        repository.getCharacter()
    }
}