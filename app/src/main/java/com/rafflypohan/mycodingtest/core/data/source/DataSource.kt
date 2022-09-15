package com.rafflypohan.mycodingtest.core.data.source

import android.util.Log
import com.rafflypohan.mycodingtest.core.data.mappers.mapToDomain
import com.rafflypohan.mycodingtest.core.data.source.api.ApiResponse
import com.rafflypohan.mycodingtest.core.data.source.api.ApiService
import com.rafflypohan.mycodingtest.core.domain.models.QuotesDetailModel
import com.rafflypohan.mycodingtest.core.domain.models.QuotesModelItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class DataSource @Inject constructor (private val apiService: ApiService) {
    fun getQuotes(): Flow<ApiResponse<List<QuotesModelItem>>> = flow {
        try {
            val response = apiService.getQuotes()
            Log.d("Data Source 1", response.results.toString())
            if (response.results != null){
                emit(ApiResponse.Success(response.results.mapToDomain()))
            } else {
                emit(ApiResponse.Empty("Results is null"))
            }
        } catch (e: HttpException){
            emit(ApiResponse.Error(e.message()))
            Log.d("Data Source 2", e.message())
        }
    }

    fun getQuotesById(id: String): Flow<ApiResponse<QuotesDetailModel>> = flow {
        try {
            val response = apiService.getQuotesById(id)
            emit(ApiResponse.Success(response.mapToDomain()))
        } catch (e: HttpException){
            emit(ApiResponse.Error(e.message()))
        }
    }
}