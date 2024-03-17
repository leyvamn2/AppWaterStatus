package com.example.testmenu

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testmenu.data.item_MainMenu
import com.example.testmenu.data.items_MenuDetalles
import com.example.testmenu.ui.detalles.PantallaNavigationBarl
import com.example.testmenu.ui.detalles.detalles_STD
import com.example.testmenu.ui.detalles.detalles_Turbidez
import com.example.testmenu.ui.detalles.detalles_pH


enum class tstScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    detalles(title = R.string.detalles),
    historico(title = R.string.historico),
    tiempoReal(title = R.string.tiempoReal)
}

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

@Composable
fun NavigationHostInicio(navController: NavHostController){
    NavHost(navController= navController,
        startDestination= item_MainMenu.inicio.ruta
    ){
        
        composable(item_MainMenu.inicio.ruta){
            PantallaPrincipal(navController)
        }
        composable(item_MainMenu.detalles.ruta){
            PantallaNavigationBarl()
        }
        /*
        composable(item_MainMenu.historicos.ruta){
           /*TODO*/
        }
        composable(item_MainMenu.tiempo_Real.ruta){
            /*TODO*/
        }
        composable(item_MainMenu.configuracion.ruta){
            /*TODO*/
        }

         */
    }
}


