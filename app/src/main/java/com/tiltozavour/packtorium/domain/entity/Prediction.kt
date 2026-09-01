package com.tiltozavour.packtorium.domain.entity

data class Prediction(
    val textPrediction: String,
    val imageUrl: String,
    val fromWho: String,
    val date: String,
    val userPrediction: Boolean
)