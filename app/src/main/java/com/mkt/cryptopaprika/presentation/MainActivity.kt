package com.mkt.cryptopaprika.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mkt.cryptopaprika.presentation.coin_details.CoinDetailsScreen
import com.mkt.cryptopaprika.presentation.coin_list.CoinListScreen
import com.mkt.cryptopaprika.presentation.ui.theme.CryptoPaprikaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoPaprikaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route){

                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController)
                        }

                        composable(route = Screen.CoinDetailsScreen.route+ "/{coinId}") {
                            CoinDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}

