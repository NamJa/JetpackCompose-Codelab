package com.secondsyndrome.jetpackcompose_pract3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.secondsyndrome.jetpackcompose_pract3.ui.theme.JetpackCompose_pract3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose_pract3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    ComposeDisplay()
                }
            }
        }
    }
}

@Composable
fun ComposeDisplay() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposeCard(title = "Text composable", content = "Displays text and follows Material Design guidelines.", modifier = Modifier.weight(1f), color = Color.Green)
            ComposeCard(title = "Image composable", content = "Creates a composable that lays out and draws a given Painter class object.", modifier = Modifier.weight(1f), color = Color.Yellow)
        }
        Row(Modifier.weight(1f)) {
            ComposeCard(title = "Row composable", content = "A layout composable that places its children in a horizontal sequence.", modifier = Modifier.weight(1f), color = Color.Cyan)
            ComposeCard(title = "Column composable", content = "A layout composable that places its children in a vertical sequence.", modifier = Modifier.weight(1f), color = Color.LightGray)
        }
    }

}

@Composable
fun ComposeCard(title: String, content: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        Text(text = title, fontWeight = FontWeight.Bold)
        Text(text = content)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackCompose_pract3Theme {
        ComposeDisplay()
    }
}