package com.example.birdseyeview_part2.model

import com.google.gson.annotations.SerializedName

data class Birds(
    @SerializedName("recordings") var birds : List<Bird> = listOf()
    )

data class Bird(
    @SerializedName("id") var id: String,
    @SerializedName("en") var birdName: String,
    @SerializedName("file") var soundUrl: String,
    @SerializedName("lat") var gpsLat: String,
    @SerializedName("lng") var gpsLng: String)

