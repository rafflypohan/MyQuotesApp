package com.rafflypohan.mycodingtest.core.data.source.api

import com.rafflypohan.mycodingtest.core.data.source.responses.QuotesDetailResponse
import com.rafflypohan.mycodingtest.core.data.source.responses.QuotesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("quotes")
    suspend fun getQuotes(): QuotesResponse

    @GET("quotes/{id}")
    suspend fun getQuotesById(@Path("id") id: String): QuotesDetailResponse
}