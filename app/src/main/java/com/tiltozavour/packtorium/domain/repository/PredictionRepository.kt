package com.tiltozavour.packtorium.domain.repository

import com.tiltozavour.packtorium.data.ResultWrapper
import com.tiltozavour.packtorium.domain.entity.Prediction
import com.tiltozavour.packtorium.domain.entity.Quota

 interface PredictionRepository {

    suspend fun getQuota(): ResultWrapper<Quota>
    suspend fun getPrediction(): ResultWrapper<Prediction>
}