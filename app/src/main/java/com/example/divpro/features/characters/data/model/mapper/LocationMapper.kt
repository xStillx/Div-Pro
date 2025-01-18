package com.example.divpro.features.characters.data.model.mapper

import com.example.divpro.features.characters.data.model.LocationResponse
import com.example.divpro.features.characters.domain.model.Location
import javax.inject.Inject

class LocationMapper @Inject constructor() {

    fun map(locationResponse: LocationResponse) = Location(
        name = locationResponse.name
    )
}