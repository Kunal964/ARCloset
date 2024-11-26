package com.example.ecommercerugsandtees.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.di.model.Product
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.usecase.GetProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val getProductUseCase: GetProductUseCase) : ViewModel() {
    private val _uistate = MutableStateFlow<HomeScreenUIEvents>(HomeScreenUIEvents.Loading)

    init {
        getAllProducts()
    }

    val uistate = _uistate.asStateFlow()
    private fun getAllProducts() {
        viewModelScope.launch {
            _uistate.value = HomeScreenUIEvents.Loading
            val featured = getProducts("Electronics")
            val popularProducts = getProducts("Jewellery")
            if (featured.isEmpty() || popularProducts.isEmpty()) {
                _uistate.value = HomeScreenUIEvents.Error("Failed to load Products")
                return@launch
            }
            _uistate.value = HomeScreenUIEvents.Success(featured, popularProducts)
        }

    }

      private suspend  fun getProducts(category: String?) : List<Product> {
            getProductUseCase.execute(category).let { result ->
                when(result) {
                    is ResultWrapper.Success -> {
                       return (result).value
                    }
                    is ResultWrapper.Failure -> {
                        return emptyList()
                    }

                }

            }

      }
   }

sealed class HomeScreenUIEvents {
    data object  Loading : HomeScreenUIEvents()
    data class Success(val featured: List<Product>, val popularProducts: List<Product>) : HomeScreenUIEvents()
    data class Error(val message: String): HomeScreenUIEvents()
}