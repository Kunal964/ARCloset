package com.example.ecommercerugsandtees.ui.theme.feature.summary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.di.model.CartSummary
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.usecase.CartSummaryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CartSummaryViewModel(private val cartSummaryUseCase: CartSummaryUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<CartSummaryEvent>(CartSummaryEvent.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getCartSummary(1)

    }

    private fun getCartSummary(userId: Long) {
        viewModelScope.launch {
            _uiState.value = CartSummaryEvent.Loading
            val summary = cartSummaryUseCase.execute(userId)
            when (summary) {
                is ResultWrapper.Success -> {
                    _uiState.value = CartSummaryEvent.Success(summary.value)
            }
                is ResultWrapper.Failure -> {
                    _uiState.value = CartSummaryEvent.Error( "Something Went Wrong")
                }

            }

        }
    }


}

sealed class CartSummaryEvent {
    data object Loading: CartSummaryEvent()
    data class Success(val summary: CartSummary): CartSummaryEvent()
    data class Error(val error: String): CartSummaryEvent()

}