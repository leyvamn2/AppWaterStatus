@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.testmenu
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.testmenu.ui.detalles.PantallaNavigationBarl
import com.example.testmenu.ui.theme.TestmenuTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
               // val navController= rememberNavController()
            PantallaNavigationBarl()
            //tutorial de navegación: https://www.youtube.com/watch?v=nwdc1ct06TI
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestmenuTheme {
        PantallaNavigationBarl()
        //val navController = rememberNavController()
        //AppNavigation(navController)
    }
}