package com.nazlinurbudak.composecounterapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HPlusMobiledata
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CounterPage(
    modifier: Modifier = Modifier,
) {

    var totalCount by remember { mutableIntStateOf(0) }
    var increaseCount by remember { mutableFloatStateOf(0F) }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.DarkGray
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CountText(totalCount = totalCount)
            Spacer(modifier = Modifier.height(50.dp))
            IncreaseButton(totalCount = totalCount) {
                totalCount += increaseCount.toInt()
            }
            Spacer(modifier = Modifier.height(100.dp))
            Text(text = "${increaseCount.toInt()}")

            Slider(
                modifier = Modifier
                    .padding(20.dp),
                value = increaseCount,
                onValueChange = {
                    increaseCount = it.roundToInt().toFloat()
                },
                valueRange = 0F..200F,
                steps = 7,
                thumb = {
                    Icon(
                        imageVector = Icons.Filled.HPlusMobiledata,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .size(30.dp),
                        contentDescription = "Increase"
                    )
                }
            )
        }
    }
}

@Composable
fun CountText(
    totalCount: Int
) {
    Text(
        text = "$totalCount",
        style = TextStyle(
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun IncreaseButton(
    modifier: Modifier = Modifier,
    totalCount: Int,
    updatedCounter: (Int) -> Unit
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .clip(CircleShape)
            .clickable {
                updatedCounter(totalCount)
            },
        elevation = CardDefaults.elevatedCardElevation(50.dp)

    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.White)
                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Tap!",
                color = Color.Blue
            )
        }
    }
}