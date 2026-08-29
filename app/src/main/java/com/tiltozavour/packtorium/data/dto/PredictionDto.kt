package com.tiltozavour.packtorium.data.dto

data class PredictionDto(
    val textPrediction: String,
    val imageUrl: String,
    val fromWho: String,
    val date: String,
)