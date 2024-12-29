package com.example.ecommercerugsandtees.utils

object CurrencyUtils {
    fun formatPrice(price: Double, currency: String = "USD") : String {
        val format = java.text.NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = java.util.Currency.getInstance(currency)
        return format.format(price)

    }
}