package com.example.testmenu.ui.detalles

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testmenu.NavigationHost
import com.example.testmenu.data.item_MainMenu
import com.example.testmenu.data.items_MenuDetalles
import kotlinx.coroutines.launch

//Pruebas navigationbar
@OptIn(ExperimentalMaterial3Api::class)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaNavigationBarl(){
    val navController= rememberNavController()
    val scaffoldState= rememberScaffoldState()
    val scope= rememberCoroutineScope()

    val items = listOf(
        item_MainMenu.inicio,
        item_MainMenu.detalles,
        item_MainMenu.historicos,
        item_MainMenu.tiempo_Real,
        item_MainMenu.configuracion
    )
    val navigation_item= listOf(
        items_MenuDetalles.pantalla_SDT,
        items_MenuDetalles.pantalla_pH,
        items_MenuDetalles.pantalla_Turbidez
    )
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }

        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.height(16.dp))
                    items.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = {
                                Text(text = item.title)
                            },
                            selected = index == selectedItemIndex,
                            onClick = {
                                navController.navigate(item.ruta)
                                selectedItemIndex = index
                                scope.launch {
                                    drawerState.close()
                                }
                            },

                            icon = {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            },

                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }

                }
            },
            drawerState = drawerState

        ) {
            Scaffold(

                topBar = {

                        },
                content={

                },
                bottomBar= {
                    NavegacionInferior(navController, navigation_item )
                }

            )
            NavigationHost(navController)
        }
    }
}


/*fun PantallaNavigationBarl(){
    val navController= rememberNavController()
    val scaffoldState= rememberScaffoldState()
    val scope= rememberCoroutineScope()
// topAppBar
    val items = listOf(
        item_MainMenu.inicio,
        item_MainMenu.detalles,
        item_MainMenu.historicos,
        item_MainMenu.tiempo_Real,
        item_MainMenu.configuracion
    )

    //bottomBar
    val navigation_item= listOf(
        items_MenuDetalles.pantalla_SDT,
        items_MenuDetalles.pantalla_pH,
        items_MenuDetalles.pantalla_Turbidez
    )
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }

        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.height(16.dp))
                    items.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = {
                                Text(text = item.title)
                            },
                            selected = index == selectedItemIndex,
                            onClick = {
                                navController.navigate(item.ruta)
                                selectedItemIndex = index
                                scope.launch {
                                    drawerState.close()
                                }
                            },

                            icon = {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            },

                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }

                }
            },
            drawerState = drawerState

        ) {
            Scaffold(

                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Inicio")
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu"
                                )
                            }
                        }
                        ,
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer

                        )
                    )


                } ,
                content={

                },
                bottomBar= {
                    NavegacionInferior(navController, navigation_item)
                }

            )
            NavigationHost(navController)
        }
    }




}*/
@Composable
fun currentRoute(navController: NavHostController):String?{
    val entrada by navController.currentBackStackEntryAsState()
    return entrada?.destination?.route

}

@Composable
fun NavegacionInferior(
    navController: NavHostController,
    menuItem: List<items_MenuDetalles>
){
    val currentRoute= currentRoute(navController = navController)
    BottomAppBar {
        BottomNavigation {
            menuItem.forEach{item ->
                BottomNavigationItem(selected = currentRoute==item.ruta,
                    //revisar error en navegacion
                    //tutorial de yt:https://www.youtube.com/watch?v=Jdz6gwoJvWo
                    onClick = { navController.navigate(item.ruta) },
                    icon = { /*TODO*/ },
                    label={ Text(item.title) })

            }
        }

    }
}

