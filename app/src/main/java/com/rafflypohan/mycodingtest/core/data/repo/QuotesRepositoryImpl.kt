package com.rafflypohan.mycodingtest.core.data.repo

import com.rafflypohan.mycodingtest.core.data.source.DataSource
import com.rafflypohan.mycodingtest.core.data.source.api.ApiResponse
import com.rafflypohan.mycodingtest.core.domain.models.QuotesDetailModel
import com.rafflypohan.mycodingtest.core.domain.models.QuotesModelItem
import com.rafflypohan.mycodingtest.core.domain.repositories.QuotesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QuotesRepositoryImpl @Inject constructor (private val dataSource: DataSource) : QuotesRepository {
    override fun getQuotes(): Flow<ApiResponse<List<QuotesModelItem>>> = dataSource.getQuotes()

    override fun getQuotesById(id: String): Flow<ApiResponse<QuotesDetailModel>> = dataSource.getQuotesById(id)
}