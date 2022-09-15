package com.rafflypohan.mycodingtest.ui.features.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafflypohan.mycodingtest.core.domain.usecases.DetailUseCase
import com.rafflypohan.mycodingtest.core.utils.Resource
import com.rafflypohan.mycodingtest.ui.navigation.Args
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: DetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(DetailUIState())
    val state: StateFlow<DetailUIState> = _state.asStateFlow()

    init {
        val id = savedStateHandle.get<String>(Args.ID)
            ?: throw IllegalStateException("No id passed to destination")
        getQuotesById(id)
    }

    private fun getQuotesById(id: String) {
        viewModelScope.launch {
            useCase.getQuotesById(id).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { q ->
                            _state.update {
                                it.copy(
                                    author = q.author,
                                    content = q.content,
                                    tags = q.tags,
                                    isLoading = false
                                )
                            }
                        }
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

data class DetailUIState(
    val author: String = "",
    val content: String = "",
    val tags: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)