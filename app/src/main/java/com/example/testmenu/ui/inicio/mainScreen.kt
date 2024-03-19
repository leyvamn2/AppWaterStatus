package com.example.testmenu.ui.inicio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testmenu.CreateGaugeChart

@Composable
fun pantallainicio(){

    Column (
        modifier = Modifier
            .padding(60.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            // .padding(50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Text(
                text="Calidad del Agua",
                modifier = Modifier.padding(25.dp),
                style = TextStyle( fontWeight = FontWeight.Bold, fontSize = 25.sp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            CreateGaugeChart()
        }
        Text(
            modifier = Modifier.padding(8.dp),
            text =
            """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    
                """.trimIndent()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick ={/*TODO*/}) {
                Text("Detalles")
            }
        }
    }
}