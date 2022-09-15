package com.rafflypohan.mycodingtest.core.data.source.responses

import com.squareup.moshi.Json

data class QuotesResponse(
	@Json(name="results")
	val results: List<QuotesResponseItem>? = null
)

data class QuotesResponseItem(

	@Json(name="_id")
	val id: String,

	@Json(name="author")
	val author: String,

	@Json(name="content")
	val content: String,
)
