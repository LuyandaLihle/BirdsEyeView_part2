package com.example.birdseyeview_part2.observations

import java.util.Date

data class Sighting(
    val species: String,
    val lat: Double,
    val lng: Double,
    val date: Date
)

data class Sight(
    val lat: Double,
    val lng: Double,
    val date: Date
)
