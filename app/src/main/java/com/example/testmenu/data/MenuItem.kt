package com.example.testmenu.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val title:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null

)

sealed class items_MenuDetalles(
    val title: String,
    val ruta: String
){
    object pantalla_pH: items_MenuDetalles("pH","pantallapH")
    object pantalla_Turbidez: items_MenuDetalles("Turbidez","pantallTurbidez")
    object pantalla_SDT: items_MenuDetalles("SDT","pantallaSDT")
}

sealed class item_MainMenu(
    val title:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val ruta: String
){
    object inicio: item_MainMenu("Inicio", Icons.Filled.Home,Icons.Outlined.Home, ruta = "pantallaPrincipal")
    object detalles: item_MainMenu("Detalles", Icons.Filled.Info,Icons.Outlined.Info, ruta = "pantallaPH")
    object historicos: item_MainMenu("Históricos", Icons.Filled.DateRange,Icons.Outlined.DateRange,ruta="historicos")
    object tiempo_Real: item_MainMenu("Tiempo Real", Icons.Filled.Refresh,Icons.Outlined.Refresh,ruta="tiempoReal")
    object configuracion: item_MainMenu("Configuración", Icons.Filled.Settings,Icons.Outlined.Settings, ruta="configuracion")

}
sealed class itemMainMenu(
    val title:String,
    val icon: ImageVector,
    val ruta: String
){
    object inicio: itemMainMenu("Inicio", Icons.Filled.Refresh,"pantallaPrincipal")
    object detalles: itemMainMenu("Detalles", Icons.Filled.Info ,"pantallaPH")
    object historicos: itemMainMenu("Históricos", Icons.Filled.DateRange,ruta="historicos")
    object tiempo_Real: itemMainMenu("Tiempo Real", Icons.Filled.Refresh,ruta="tiempoReal")
    object configuracion: itemMainMenu("Configuración", Icons.Filled.Settings,ruta="configuracion")

}