package com.tiltozavour.packtorium.data.repositoryImpl

import com.tiltozavour.packtorium.domain.entity.Prediction
import com.tiltozavour.packtorium.domain.entity.Quota
import com.tiltozavour.packtorium.domain.repository.PredictionRepository

internal class PredictionRepositoryImpl() : PredictionRepository {

    override fun getQuota() = Quota(
        quotaDay = "Мы там дело на пол дела не да"
    )

    override fun getPrediction(): Prediction =
        Prediction(
            textPrediction = "Всё получится!",
            imageUrl = "https://i.pinimg.com/1200x/eb/0e/62/eb0e62c55ed38c14edda1e57741aaec3.jpg",
            fromWho = "Destiny",
            date = "28.08.2026",
        )
}