package com.tiltozavour.packtorium.di

import com.tiltozavour.packtorium.data.repositoryImpl.PredictionRepositoryImpl
import com.tiltozavour.packtorium.domain.repository.PredictionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindPredictionRepository(repository: PredictionRepositoryImpl): PredictionRepository

}