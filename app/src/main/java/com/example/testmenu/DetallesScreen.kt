package com.example.testmenu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun Detalles_PH(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()){
        NavigationDrawer()
    }
}