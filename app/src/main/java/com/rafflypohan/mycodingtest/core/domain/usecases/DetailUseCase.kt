package com.rafflypohan.mycodingtest.core.domain.usecases

import com.rafflypohan.mycodingtest.core.domain.models.QuotesDetailModel
import com.rafflypohan.mycodingtest.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DetailUseCase {
    fun getQuotesById(id: String): Flow<Resource<QuotesDetailModel>>
}