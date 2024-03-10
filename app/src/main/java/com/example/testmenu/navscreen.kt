package com.example.testmenu

import android.icu.text.CaseMap.Title
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testmenu.data.items_MenuDetalles



@Composable
fun NavigationHost(navController: NavHostController){
    NavHost(navController= navController,
        startDestination= items_MenuDetalles.pantalla_pH.ruta
    ){
        composable(items_MenuDetalles.pantalla_pH.ruta){
            detalles_pH()
         }
        composable(items_MenuDetalles.pantalla_Turbidez.ruta){
            detalles_Turbidez()
        }
        composable(items_MenuDetalles.pantalla_SDT.ruta){
            detalles_STD()
        }
    }
}



