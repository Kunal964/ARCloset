package com.example.ecommercerugsandtees.ui.theme.feature.product_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.di.model.request.AddCartRequestModel
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.usecase.AddToCartUseCase
import com.example.ecommercerugsandtees.model.UiProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductDetailsViewModel(val useCase: AddToCartUseCase) : ViewModel()  {
    private val _state = MutableStateFlow<ProductDetailsEvent>(ProductDetailsEvent.Nothing)
    val state = _state.asStateFlow()

    fun addProductToCart(product: UiProductModel) {
        viewModelScope.launch {
            _state.value = ProductDetailsEvent.Loading
            val result = useCase.execute(
                AddCartRequestModel(
                 product.id,
                 product.title,
                 product.price,
                1,
                1
                )
            )
            when (result) {
                is ResultWrapper.Success -> {
                    _state.value = ProductDetailsEvent.Success("Product Added To Cart")
                }
                is ResultWrapper.Failure -> {
                    _state.value = ProductDetailsEvent.Error("Something Went Wrong")
                }

            }
        }
    }

}

sealed class ProductDetailsEvent {
    data object Loading: ProductDetailsEvent()
    data object Nothing: ProductDetailsEvent()
    data class Success(val message: String) : ProductDetailsEvent()
    data class Error(val message: String) : ProductDetailsEvent()

}