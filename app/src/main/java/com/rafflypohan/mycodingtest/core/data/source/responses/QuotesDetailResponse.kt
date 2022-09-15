package com.rafflypohan.mycodingtest.core.data.source.responses

import com.squareup.moshi.Json

data class QuotesDetailResponse(

	@Json(name="_id")
	val id: String,

	@Json(name="author")
	val author: String,

	@Json(name="content")
	val content: String,

	@Json(name="tags")
	val tags: List<String>
)
