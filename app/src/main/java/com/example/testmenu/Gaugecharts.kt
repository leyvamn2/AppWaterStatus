package com.example.testmenu

import android.graphics.Color
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlin.random.Random


@Composable
fun CreateGaugeChart(){
    val value = Random.nextInt(1, 100).toFloat()

    Column(
        modifier = Modifier.size(250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        AndroidView(factory = { ctx ->
            PieChart(ctx).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,

                    )
                // Configurar el gráfico
                setUsePercentValues(true)
                description.isEnabled = false
                legend.isEnabled = false
                setDrawHoleEnabled(true)
                setHoleColor(Color.TRANSPARENT)
                setTransparentCircleColor(Color.TRANSPARENT)
                setTransparentCircleAlpha(0)
                isRotationEnabled = false
                setTouchEnabled(false)

                // Configurar datos
                val dataEntries = ArrayList<PieEntry>()
                dataEntries.add(PieEntry(value))
                dataEntries.add(PieEntry(100f - value)) // Restante

                val dataSet = PieDataSet(dataEntries, "").apply {
                    colors = mutableListOf<Int>().apply {
                        add(
                            when {
                                value > 95 -> Color.parseColor("#86895D")
                                value in 90f..94f -> Color.parseColor("#B4C619")
                                value in 80f..89f -> Color.parseColor("#FFD700")
                                value in 70f..79f -> Color.parseColor("#FFA500")
                                else -> Color.RED
                            }
                        )
                        add(Color.LTGRAY) //
                    }
                }
                dataSet.sliceSpace = 0f

                val data = PieData(dataSet)
                data.setDrawValues(false)

                // Establecer datos en el gráfico
                setData(data)

                invalidate()
            }
        })
    }

}