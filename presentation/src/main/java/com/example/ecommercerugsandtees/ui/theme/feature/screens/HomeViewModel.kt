package com.example.ecommercerugsandtees.ui.theme.feature.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.di.model.Product
import com.example.domain.di.network.ResultWrapper
import com.example.domain.di.usecase.GetCategoryUseCase
import com.example.domain.di.usecase.GetProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val getProductUseCase: GetProductUseCase,
                    private val getCategoryUseCase: GetCategoryUseCase) : ViewModel() {
    private val _uistate = MutableStateFlow<HomeScreenUIEvents>(HomeScreenUIEvents.Loading)

    init {
        getAllProducts()
    }

    val uistate = _uistate.asStateFlow()
    private fun getAllProducts() {
        viewModelScope.launch {
            _uistate.value = HomeScreenUIEvents.Loading
            val featured = getProducts(1)
            val popularProducts = getProducts(2)
            val categories = getCategory()
            if (featured.isEmpty() || popularProducts.isEmpty() && categories.isNotEmpty()) {
                _uistate.value = HomeScreenUIEvents.Error("Failed to load Products")
                return@launch
            }
            _uistate.value = HomeScreenUIEvents.Success(featured, popularProducts, categories)
        }
    }
    private suspend fun getCategory(): List<String> {
        getCategoryUseCase.execute().let { result ->
            when (result) {
                is ResultWrapper.Success -> {
                    return (result).value.categories.map { it.title }
                }
                is ResultWrapper.Failure -> {
                    return emptyList()
                }
            }
        }
    }

      private suspend  fun getProducts(category: Int?) : List<Product> {
            getProductUseCase.execute(category).let { result ->
                when(result) {
                    is ResultWrapper.Success -> {
                       return (result).value.products
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
    data class Success(
        val featured: List<Product>,
        val popularProducts: List<Product>,
        val categories: List<String>
        ) : HomeScreenUIEvents()
    data class Error(val message: String): HomeScreenUIEvents()
}