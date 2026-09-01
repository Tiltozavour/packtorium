package com.tiltozavour.packtorium.data.dto

import com.google.firebase.Timestamp

data class PredictionDto(
    val textPrediction: String = "",
    val imageUrl: String = "",
    val fromWho: String = "",
    val date: Timestamp = Timestamp.now(),
    val userPrediction: Boolean = false,
)