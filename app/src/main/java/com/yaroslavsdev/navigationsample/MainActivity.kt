package com.yaroslavsdev.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yaroslavsdev.navigationsample.ui.screens.mainScreen.MainScreen
import com.yaroslavsdev.navigationsample.ui.screens.productCard.ProductCard
import com.yaroslavsdev.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        val nav = rememberNavController()
                        NavHost(
                            navController = nav,
                            startDestination = "main",
                            modifier = Modifier.fillMaxSize()
                        ) {
                            composable("main") {
                                MainScreen(
                                    onButtonClicked = { id -> nav.navigate("detail/$id") }
                                )
                            }
                            composable(
                                route = "detail/{id}",
                                arguments = listOf(
                                    navArgument("id") {
                                        type = NavType.IntType
                                    }
                                )
                            ) { entry ->
                                val arguments = requireNotNull(entry.arguments)
                                val currentId = arguments.getInt("id", 0)
                                ProductCard(
                                    id = currentId,
                                    onBackClicked = { nav.popBackStack() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}