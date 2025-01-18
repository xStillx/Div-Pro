package com.example.divpro.features.characters.data.model.mapper

import com.example.divpro.features.characters.data.model.ResultsResponse
import com.example.divpro.features.characters.domain.model.Result
import javax.inject.Inject

class ResultMapper @Inject constructor(
    private val locationMapper: LocationMapper
) {

    fun map(resultsResponse: ResultsResponse) = Result(
        id = resultsResponse.id,
        name = resultsResponse.name,
        status = resultsResponse.status,
        species = resultsResponse.species,
        type = resultsResponse.type,
        gender = resultsResponse.gender,
        location = resultsResponse.location.let {
            locationMapper.map(it)
        },
        image = resultsResponse.image
    )
}