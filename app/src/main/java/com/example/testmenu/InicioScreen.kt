package com.example.testmenu

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.ModalDrawer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.testmenu.data.item_MainMenu
import kotlinx.coroutines.launch

//import androidx.navigation.NavController

//import androidx.navigation.compose.rememberNavController
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testmenu.data.MenuItem
import com.example.testmenu.data.itemMainMenu
import com.example.testmenu.data.items_MenuDetalles
import com.example.testmenu.ui.detalles.currentRoute
import com.example.testmenu.ui.inicio.pantallainicio
import kotlinx.coroutines.CoroutineScope


@Composable
fun pantallaPrincipal() {

    Box(modifier = Modifier.fillMaxSize()){
        Scaffoldtst()
       // NavigationDrawer(navController)
        //Content()
    }

}





@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffoldtst() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val navigationItems = listOf(
        itemMainMenu.inicio,
        itemMainMenu.detalles,
        itemMainMenu.historicos,
        itemMainMenu.tiempo_Real,
        itemMainMenu.configuracion
    )
    val topAppBarColors = TopAppBarDefaults.smallTopAppBarColors()

    Scaffold(
        scaffoldState= scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = getTitleForRoute(currentRoute)) },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                }


            )

        },

        drawerContent = {
            Drawer(
                scope,
                scaffoldState,
                navController,
                items = navigationItems
            )
        })
    {
        NavigationHostInicio(navController)
    }
}

@Composable
fun Drawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavHostController, // Corregido aquí
    items: List<itemMainMenu> // Corregido aquí
) {
    Image(
        painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        modifier = Modifier
            .height(260.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(15.dp))
    val currenRoute= currentRoute(navController)
    Column {
        items.forEach { item ->
            DrawerItem(item,
                selected= currenRoute==item.ruta
                ){
                navController.navigate(item.ruta){
                    launchSingleTop=true
                }
                scope.launch { scaffoldState.drawerState.close() }
            }
        }
    }
}

    // Implement your drawer content here

@Composable
fun getTitleForRoute(route: String?): String {
    return when (route) {
        "pantallaPrincipal" -> "Inicio"
        "pantallaPH" -> "Detalles"
        // Agrega más casos según las rutas de tus pantallas
        else -> "Inicio" // Por defecto
    }
}

@Composable
fun currentRoute(navController: NavHostController):String?{
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
@Composable
fun DrawerItem(item: itemMainMenu,
               selected: Boolean,
               onItemClick: (itemMainMenu)-> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(12))
            .background(if(selected)MaterialTheme.colors.primaryVariant.copy(alpha = 0.25f)
                else Color.Transparent)
            .clickable { onItemClick(item) }
    ) {

        Spacer(modifier = Modifier.width(12.dp))

        Text(text=item.title,
            style = MaterialTheme.typography.body1)
    }
}
