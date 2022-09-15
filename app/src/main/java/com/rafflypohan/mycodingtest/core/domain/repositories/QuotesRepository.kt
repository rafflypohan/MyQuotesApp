package com.rafflypohan.mycodingtest.core.domain.repositories

import com.rafflypohan.mycodingtest.core.data.source.api.ApiResponse
import com.rafflypohan.mycodingtest.core.domain.models.QuotesDetailModel
import com.rafflypohan.mycodingtest.core.domain.models.QuotesModelItem
import kotlinx.coroutines.flow.Flow

interface QuotesRepository {
    fun getQuotes(): Flow<ApiResponse<List<QuotesModelItem>>>
    fun getQuotesById(id: String): Flow<ApiResponse<QuotesDetailModel>>
}