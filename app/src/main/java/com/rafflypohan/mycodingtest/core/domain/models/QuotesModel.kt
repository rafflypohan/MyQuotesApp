package com.rafflypohan.mycodingtest.core.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuotesModel(
	val results: List<QuotesModelItem>? = null
) : Parcelable

@Parcelize
data class QuotesModelItem(
	val id: String,
	val author: String,
	val content: String,
) : Parcelable
