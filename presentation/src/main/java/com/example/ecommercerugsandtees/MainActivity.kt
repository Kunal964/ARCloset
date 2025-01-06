package com.example.ecommercerugsandtees

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ecommercerugsandtees.model.UiProductModel
import com.example.ecommercerugsandtees.navigation.productNavType
import com.example.ecommercerugsandtees.navigation.CartScreen
import com.example.ecommercerugsandtees.navigation.CartSummaryScreen
import com.example.ecommercerugsandtees.navigation.HomeScreen
import com.example.ecommercerugsandtees.navigation.LoginScreen
import com.example.ecommercerugsandtees.navigation.OrdersScreen
import com.example.ecommercerugsandtees.navigation.ProductDetails
import com.example.ecommercerugsandtees.navigation.ProfileScreen
import com.example.ecommercerugsandtees.navigation.RegisterScreen
import com.example.ecommercerugsandtees.navigation.UserAddressRoute
import com.example.ecommercerugsandtees.navigation.UserAddressRouteWrapper
import com.example.ecommercerugsandtees.navigation.userAddressNavType
import com.example.ecommercerugsandtees.ui.theme.feature.screens.HomeScreen
import com.example.ecommercerugsandtees.ui.theme.ECommerceRugsandTeesTheme
import com.example.ecommercerugsandtees.ui.theme.feature.account.login.LoginScreen
import com.example.ecommercerugsandtees.ui.theme.feature.account.register.RegisterScreen
import com.example.ecommercerugsandtees.ui.theme.feature.cart.CartScreen
import com.example.ecommercerugsandtees.ui.theme.feature.orders.OrdersScreen
import com.example.ecommercerugsandtees.ui.theme.feature.product_details.ProductDetailsScreen
import com.example.ecommercerugsandtees.ui.theme.feature.summary.CartSummaryScreen
import com.example.ecommercerugsandtees.user_address.UserAddressScreen
import org.koin.android.ext.android.inject
import kotlin.reflect.typeOf


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val shopperSession : ShopperSession by inject()
            ECommerceRugsandTeesTheme {
                val shouldShowBottomNav = remember {
                    mutableStateOf(true)
                }
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AnimatedVisibility(visible = shouldShowBottomNav.value, enter = fadeIn()) {
                            BottomNavigationBar(navController)
                        }
                    }
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = if (shopperSession.getUser() != null) {
                                HomeScreen
                            } else {
                                LoginScreen
                            }
                        ) {
                            composable<LoginScreen> {
                                shouldShowBottomNav.value = false
                                LoginScreen(navController)
                            }
                            composable<RegisterScreen> {
                                shouldShowBottomNav.value = false
                                RegisterScreen(navController)
                            }
                            composable<HomeScreen> {
                                shouldShowBottomNav.value = true
                                HomeScreen(navController)

                            }
                            composable<CartScreen> {
                                shouldShowBottomNav.value = true
                                   CartScreen(navController)

                            }
                            composable<OrdersScreen> {
                                shouldShowBottomNav.value = true
                                OrdersScreen()
                            }
                            composable<ProfileScreen> {
                                shouldShowBottomNav.value = true
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Text(text = "Profile")
                                }
                            }
                            composable<CartSummaryScreen> {
                                shouldShowBottomNav.value = false
                                CartSummaryScreen(navController = navController)
                            }
                            composable<ProductDetails>(
                                typeMap = mapOf(typeOf<UiProductModel>() to productNavType)
                            ){
                                shouldShowBottomNav.value = false
                                val productRoute = it.toRoute<ProductDetails>()
                                ProductDetailsScreen(navController, productRoute.product)

                            }
                            composable<UserAddressRoute>(
                                typeMap = mapOf(typeOf<UserAddressRouteWrapper>() to userAddressNavType)
                            ) {
                                shouldShowBottomNav.value = false
                                val userAddressRoute = it.toRoute<UserAddressRoute>()
                                UserAddressScreen(
                                    navController = navController,
                                    userAddress = userAddressRoute.userAddressWrapper.userAddress
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        val items = listOf(
            BottomNavItems.Home,
            BottomNavItems.Orders,
            BottomNavItems.Profile
        )

        items.forEach { item ->
            val isSelected = currentRoute?.substringBefore("?") == item.route::class.qualifiedName
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route)
                },
                label = { Text(text = item.title)},
                icon = {
                   Image(
                       painter = painterResource(id = item.icon),
                       contentDescription = null,
                       colorFilter = ColorFilter.tint(if (isSelected) Color(0xFFAAA8C2) else Color.Gray))
                },
                colors = NavigationBarItemDefaults.colors().copy(
                    selectedIndicatorColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = Color.Gray,
                    unselectedIconColor = Color.Gray

                )
            )
        }
    }
}



sealed class BottomNavItems(val route: Any, val title: String, val icon: Int) {
    object Home: BottomNavItems(HomeScreen,"Home", icon = R.drawable.ic_home)
    object Orders: BottomNavItems(OrdersScreen,"Orders", icon = R.drawable.ic_orders)
    object Profile: BottomNavItems(ProfileScreen, "Profile", icon = R.drawable.profile)
}

