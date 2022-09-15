package com.rafflypohan.mycodingtest.ui.di

import com.rafflypohan.mycodingtest.core.domain.usecases.DetailUseCase
import com.rafflypohan.mycodingtest.core.domain.usecases.HomeUseCase
import com.rafflypohan.mycodingtest.core.domain.usecases.interactors.DetailInteractor
import com.rafflypohan.mycodingtest.core.domain.usecases.interactors.HomeInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    @Singleton
    abstract fun bindHomeUseCase(
        homeInteractor: HomeInteractor
    ): HomeUseCase

    @Binds
    @Singleton
    abstract fun bindDetailUseCase(
        detailInteractor: DetailInteractor
    ): DetailUseCase
}