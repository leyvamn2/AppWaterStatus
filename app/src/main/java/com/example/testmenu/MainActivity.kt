@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.testmenu
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.compose.rememberNavController
import com.example.testmenu.ui.detalles.PantallaNavigationBarl
import com.example.testmenu.ui.theme.TestmenuTheme
import kotlinx.coroutines.CoroutineScope


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            pantallaPrincipal()
            //tutorial de navegación: https://www.youtube.com/watch?v=nwdc1ct06TI
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestmenuTheme {
        pantallaPrincipal()
        //val navController = rememberNavController()
        //AppNavigation(navController)
    }
}