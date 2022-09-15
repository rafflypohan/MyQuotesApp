package com.rafflypohan.mycodingtest.core.data.mappers

import com.rafflypohan.mycodingtest.core.data.source.responses.QuotesDetailResponse
import com.rafflypohan.mycodingtest.core.data.source.responses.QuotesResponseItem
import com.rafflypohan.mycodingtest.core.domain.models.QuotesDetailModel
import com.rafflypohan.mycodingtest.core.domain.models.QuotesModelItem

fun List<QuotesResponseItem>.mapToDomain(): List<QuotesModelItem> = this.map {
    QuotesModelItem(id = it.id, author = it.author, content = it.content)
}

fun QuotesDetailResponse.mapToDomain(): QuotesDetailModel = QuotesDetailModel(id, author, content, tags)
