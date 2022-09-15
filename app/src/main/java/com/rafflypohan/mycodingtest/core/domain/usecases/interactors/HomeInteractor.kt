package com.rafflypohan.mycodingtest.core.domain.usecases.interactors

import com.rafflypohan.mycodingtest.core.data.source.api.ApiResponse
import com.rafflypohan.mycodingtest.core.domain.models.QuotesModelItem
import com.rafflypohan.mycodingtest.core.domain.repositories.QuotesRepository
import com.rafflypohan.mycodingtest.core.domain.usecases.HomeUseCase
import com.rafflypohan.mycodingtest.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class HomeInteractor @Inject constructor (private val repository: QuotesRepository): HomeUseCase {
    override suspend fun getQuotes(): Flow<Resource<List<QuotesModelItem>>> = flow {
        repository.getQuotes().onStart {
            emit(Resource.Loading())
        }.collect {
            when(it){
                is ApiResponse.Success -> emit(Resource.Success(it.data))
                is ApiResponse.Error -> emit(Resource.Error(it.errorMessage, null))
                is ApiResponse.Empty -> emit(Resource.Error(it.errorMessage))
            }
        }
    }
}