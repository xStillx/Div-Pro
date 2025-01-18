package com.example.divpro.features.characters.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterResponse(
    val results: List<ResultsResponse>
)

@JsonClass(generateAdapter = true)
data class ResultsResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val location: LocationResponse,
    val image: String
)

@JsonClass(generateAdapter = true)
data class LocationResponse(
    val name: String
)