package com.rafflypohan.mycodingtest.core.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuotesDetailModel(
	val id: String,
	val author: String,
	val content: String,
	val tags: List<String>
) : Parcelable
