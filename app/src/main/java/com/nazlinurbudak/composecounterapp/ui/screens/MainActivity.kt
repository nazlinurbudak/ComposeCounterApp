package com.nazlinurbudak.composecounterapp.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nazlinurbudak.composecounterapp.ui.components.CounterPage
import com.nazlinurbudak.composecounterapp.ui.theme.ComposeCounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCounterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   CounterPage(
                       modifier = Modifier.padding(innerPadding)
                   )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeCounterAppTheme {
        CounterPage()
    }
}