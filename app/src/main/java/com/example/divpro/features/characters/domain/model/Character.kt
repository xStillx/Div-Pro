package com.example.divpro.features.characters.domain.model

data class Character(
    val results: List<Result>
)

data class Result(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val location: Location,
    val image: String
)

data class Location(
    val name: String
)