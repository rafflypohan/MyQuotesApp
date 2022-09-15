package com.rafflypohan.mycodingtest.core.domain.usecases

import com.rafflypohan.mycodingtest.core.domain.models.QuotesModelItem
import com.rafflypohan.mycodingtest.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface HomeUseCase {
    suspend fun getQuotes(): Flow<Resource<List<QuotesModelItem>>>
}