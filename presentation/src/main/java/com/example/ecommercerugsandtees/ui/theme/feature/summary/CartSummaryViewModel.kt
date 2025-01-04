package com.example.ecommercerugsandtees.ui.theme.feature.summary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.di.model.CartSummary
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.usecase.CartSummaryUseCase
import com.example.domain.di.usecase.PlaceOrderUseCase
import com.example.ecommercerugsandtees.ShopperSession
import com.example.ecommercerugsandtees.model.UserAddress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CartSummaryViewModel(
    private val cartSummaryUseCase: CartSummaryUseCase,
    private val placeOrderUseCase: PlaceOrderUseCase,
    private val shopperSession: ShopperSession
    ) : ViewModel() {
    private val _uiState = MutableStateFlow<CartSummaryEvent>(CartSummaryEvent.Loading)
    val uiState = _uiState.asStateFlow()
    val userDomainModel = shopperSession.getUser()

    init {
        getCartSummary(userDomainModel!!.id!!.toLong())

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
                    _uiState.value = CartSummaryEvent.Error("Something Went Wrong")
                }

            }

        }
    }

    fun placeOrder(userAddress: UserAddress) {
        viewModelScope.launch {
            _uiState.value = CartSummaryEvent.Loading
            val orderId = placeOrderUseCase.execute(userAddress.toAddressDataModel(),userDomainModel!!.id!!.toLong())
            when (orderId) {
                is ResultWrapper.Success -> {
                    _uiState.value = CartSummaryEvent.PlaceOrder(orderId.value)
                }

                is ResultWrapper.Failure -> {
                    _uiState.value = CartSummaryEvent.Error("Something Went Wrong")
                }

            }
        }
    }

}
sealed class CartSummaryEvent {
    data object Loading : CartSummaryEvent()
    data class Success(val summary: CartSummary) : CartSummaryEvent()
    data class Error(val error: String) : CartSummaryEvent()
    data class PlaceOrder(val orderId: Long) : CartSummaryEvent()

}