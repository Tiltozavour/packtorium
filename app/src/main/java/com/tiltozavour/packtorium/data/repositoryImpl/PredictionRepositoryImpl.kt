package com.tiltozavour.packtorium.data.repositoryImpl

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import com.tiltozavour.packtorium.data.ResultWrapper
import com.tiltozavour.packtorium.data.dto.PredictionDto
import com.tiltozavour.packtorium.data.dto.QuotaDto
import com.tiltozavour.packtorium.data.mapper.CookieMapping
import com.tiltozavour.packtorium.domain.entity.Prediction
import com.tiltozavour.packtorium.domain.entity.Quota
import com.tiltozavour.packtorium.domain.repository.PredictionRepository
import kotlinx.coroutines.tasks.await

internal class PredictionRepositoryImpl(
    private val mapper: CookieMapping, //todo DI
) : PredictionRepository {

    val bd = Firebase.firestore

    override suspend fun getQuota(): ResultWrapper<Quota> {
        return try {
            val snap = bd.collection(QUOTA)
                .get()
                .await()
            val qoots = snap.documents.firstNotNullOf {
                it.toObject<QuotaDto>()
            }
            ResultWrapper.Success(mapper.mappingQuotaDtoToEntity(qoots))
        } catch (e: Exception) {
            ResultWrapper.Error(e)
        }
    }

    override suspend fun getPrediction(): ResultWrapper<Prediction> {
        return try {
            val snap = bd.collection(PREDICTION)
                .get()
                .await()
            val predict = snap.documents.firstNotNullOf {
                it.toObject<PredictionDto>()
            }
            ResultWrapper.Success(mapper.mappingPredictionDtoToEntity(predict))
        } catch (e: Exception) {
            ResultWrapper.Error(e)
        }
    }

    companion object {
        private const val QUOTA = "quota"
        private const val PREDICTION = "prediction"
    }
}