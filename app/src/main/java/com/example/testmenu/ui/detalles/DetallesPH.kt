package com.example.testmenu.ui.detalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testmenu.CreateGaugeChart
import com.example.testmenu.ui.theme.TestmenuTheme
import com.example.testmenu.ui.tiempo_real.detalles_tiemporeal

@Composable
fun detalles_pH(){
  //  PantallaNavigationBarl()
    Column {
        Row(modifier = Modifier
            .fillMaxWidth(),
            // .padding(50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,


            )

        {
            Text( text="pH",
                modifier = Modifier.padding(25.dp),
                style = TextStyle( fontWeight = FontWeight.Bold, fontSize = 25.sp
                )
            )
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically)
        {
            CreateGaugeChart()
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Text( text="Lorem Ipsum",
                modifier = Modifier.padding(10.dp),
                style = TextStyle( fontWeight = FontWeight.Bold, fontSize = 20.sp
                )
            )
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            androidx.compose.material3.Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    
                """.trimIndent()
            )
        }


    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestmenuTheme {
        detalles_pH()
        //val navController = rememberNavController()
        //AppNavigation(navController)
    }
}