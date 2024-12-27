package com.example.ecommercerugsandtees.ui.theme.feature.cart

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.di.model.CartItemModel
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.usecase.GetCartUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CartViewModel(val cartUseCase: GetCartUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<CartEvent>(CartEvent.Loading)
    val uiState = _uiState.asStateFlow()
    init {
        getCart()
    }

    fun getCart() {
        viewModelScope.launch {
            _uiState.value = CartEvent.Loading
            cartUseCase.execute().let { result ->
                when (result) {
                    is ResultWrapper.Success -> {
                        Log.d("CartViewModel", "Cart items: ${result.value.data}")
                        _uiState.value = CartEvent.Success(result.value.data)
                    }
                    is ResultWrapper.Failure -> {
                        Log.e("CartViewModel", "Error: ${result.exception}")
                        _uiState.value = CartEvent.Error("Something went wrong!")
                    }
                }
            }
        }
    }
}

sealed class CartEvent {
    object Loading : CartEvent()
    data class Success(val message: List<CartItemModel>) : CartEvent()
    data class Error(val message: String) : CartEvent()

}