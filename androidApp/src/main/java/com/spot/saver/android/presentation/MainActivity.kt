package com.spot.saver.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.spot.saver.android.theme.SpotSaverTheme
import com.spot.saver.android.presentation.ui.screens.add.AddSpotPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotSaverTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddSpotPage()
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    SpotSaverTheme {
        GreetingView("Hello, Android!")
    }
}
