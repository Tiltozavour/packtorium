package com.tiltozavour.packtorium.data.mapper

import com.tiltozavour.packtorium.data.dto.PredictionDto
import com.tiltozavour.packtorium.data.dto.QuotaDto
import com.tiltozavour.packtorium.domain.entity.Prediction
import com.tiltozavour.packtorium.domain.entity.Quota

internal class CookieMapping { //to api

    fun mappingPredictionDtoToEntity(dto: PredictionDto) = Prediction(
        textPrediction = dto.textPrediction,
        imageUrl = dto.imageUrl,
        fromWho = dto.fromWho,
        date = dto.date.toString(),
        userPrediction = dto.userPrediction
    )

    fun mappingQuotaDtoToEntity(dto: QuotaDto) = Quota(
        quota = dto.quota
    )

}