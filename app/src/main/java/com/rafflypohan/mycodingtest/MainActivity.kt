package com.rafflypohan.mycodingtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.rafflypohan.mycodingtest.ui.navigation.NavGraph
import com.rafflypohan.mycodingtest.ui.theme.MyCodingTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCodingTestTheme {
                QuotesApp()
            }
        }
    }
}

@Composable
fun QuotesApp(){
    val navController = rememberNavController()
    NavGraph(navController = navController)
}
