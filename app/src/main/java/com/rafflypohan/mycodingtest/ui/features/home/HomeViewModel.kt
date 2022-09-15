package com.rafflypohan.mycodingtest.ui.features.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafflypohan.mycodingtest.core.domain.models.QuotesModelItem
import com.rafflypohan.mycodingtest.core.domain.usecases.HomeUseCase
import com.rafflypohan.mycodingtest.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: HomeUseCase) : ViewModel() {
    private val _state = MutableStateFlow(HomeUIState())
    val state: StateFlow<HomeUIState> = _state.asStateFlow()

    init {
        getQuotes()
    }

    private fun getQuotes() {
        viewModelScope.launch {
            useCase.getQuotes().collect { result ->
                Log.d("View model 1", result.message.toString())
                result.data?.toString()?.let { Log.d("view model 2", it) }
                when (result) {
                    is Resource.Success -> {
                        _state.update { it.copy(quotes = result.data!!, isLoading = false) }
                    }
                    is Resource.Error -> {
                        _state.update { it.copy(isLoading = false, errorMessage = result.message) }
                    }
                    is Resource.Loading -> {
                        _state.update { it.copy(isLoading = true) }
                    }
                }
            }
        }
    }
}

data class HomeUIState(
    val quotes: List<QuotesModelItem> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)