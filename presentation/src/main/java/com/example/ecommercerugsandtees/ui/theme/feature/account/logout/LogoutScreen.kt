package com.example.ecommercerugsandtees.ui.feature.account.logout

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ecommercerugsandtees.ShopperSession
import com.example.ecommercerugsandtees.navigation.LoginScreen

@Composable
fun LogoutScreen(navController: NavController, context: Context, shopperSession: ShopperSession) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Are you sure you want to logout?")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            shopperSession.clearUser() // Clear user data
            Toast.makeText(context, "Logged out successfully", Toast.LENGTH_SHORT).show()
            navController.navigate(LoginScreen) {
                popUpTo(0) // Clear back stack
            }
        }) {
            Text(text = "Logout")
        }
    }
}
