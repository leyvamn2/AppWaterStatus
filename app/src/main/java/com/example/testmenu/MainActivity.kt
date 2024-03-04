@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.testmenu
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.testmenu.ui.theme.TestmenuTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestmenuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNavigation(navController)
                }
            }
        }
    }
}
@Composable
fun AppNavigation(navController: NavHostController) { // Cambia NavController a NavHostController
    NavHost(navController = navController, startDestination = "Home") {
        composable(route = "Home") {
            PantallaPrincipal(navController)
        }
        composable(route = "Detalles") {
            Detalles_PH(navController)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestmenuTheme {
        //val navController = rememberNavController()
        val navController = rememberNavController()
        AppNavigation(navController)
    }
}