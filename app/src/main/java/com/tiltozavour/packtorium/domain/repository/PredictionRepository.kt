package com.tiltozavour.packtorium.domain.repository

import com.tiltozavour.packtorium.domain.entity.Prediction
import com.tiltozavour.packtorium.domain.entity.Quota

internal interface PredictionRepository {

    fun getQuota(): Quota
    fun getPrediction(): Prediction
}