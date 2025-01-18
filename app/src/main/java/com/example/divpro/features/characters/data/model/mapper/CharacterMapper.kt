package com.example.divpro.features.characters.data.model.mapper

import com.example.divpro.features.characters.data.model.CharacterResponse
import com.example.divpro.features.characters.domain.model.Character
import javax.inject.Inject

class CharacterMapper @Inject constructor(
    private val resultMapper: ResultMapper
) {

    fun map(characterResponse: CharacterResponse) = Character(
        results = characterResponse.results.map {
            resultMapper.map(it)
        }
    )
}