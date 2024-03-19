package com.example.testmenu

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.Image
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
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.testmenu.data.MenuItem
import com.example.testmenu.data.itemMainMenu
import com.example.testmenu.data.items_MenuDetalles
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
    val navigationItems = listOf(
        itemMainMenu.inicio,
        itemMainMenu.detalles,
        itemMainMenu.historicos,
        itemMainMenu.tiempo_Real,
        itemMainMenu.configuracion
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(
        scaffoldState= scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Inicio") },
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
    Column {
        items.forEach { item ->
            DrawerItem(item){
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
fun DrawerItem(item: itemMainMenu,
               onItemClick: (itemMainMenu)-> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(10.dp)
            .clickable { onItemClick(item) }
    ) {
        //Icon(painterResource(id=ind),
          //  contentDescription = item.title)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text=item.title,
            style = MaterialTheme.typography.body1)
    }
}
