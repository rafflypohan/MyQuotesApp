package com.rafflypohan.mycodingtest.core.domain.usecases.interactors

import com.rafflypohan.mycodingtest.core.data.source.api.ApiResponse
import com.rafflypohan.mycodingtest.core.domain.models.QuotesDetailModel
import com.rafflypohan.mycodingtest.core.domain.repositories.QuotesRepository
import com.rafflypohan.mycodingtest.core.domain.usecases.DetailUseCase
import com.rafflypohan.mycodingtest.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class DetailInteractor @Inject constructor (private val repository: QuotesRepository) : DetailUseCase {
    override fun getQuotesById(id: String): Flow<Resource<QuotesDetailModel>> = flow {
        repository.getQuotesById(id).onStart {
            emit(Resource.Loading())
        }.collect {
            when (it) {
                is ApiResponse.Success -> emit(Resource.Success(it.data))
                is ApiResponse.Error -> emit(Resource.Error(it.errorMessage, null))
                is ApiResponse.Empty -> emit(Resource.Error(it.errorMessage))
            }
        }
    }
}