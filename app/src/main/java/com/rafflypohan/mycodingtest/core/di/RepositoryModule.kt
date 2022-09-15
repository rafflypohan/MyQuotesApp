package com.rafflypohan.mycodingtest.core.di

import com.rafflypohan.mycodingtest.core.data.repo.QuotesRepositoryImpl
import com.rafflypohan.mycodingtest.core.domain.repositories.QuotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindQuotesRepository(
        quotesRepositoryImpl: QuotesRepositoryImpl
    ): QuotesRepository
}