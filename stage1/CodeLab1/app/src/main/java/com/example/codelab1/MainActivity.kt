package com.example.codelab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.codelab1.ui.theme.CodeLab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeLab1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayGreetingWithText(message = "Happy Birthday Sam", from = "- from emma")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String, modifier :Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = message, fontSize = 36.sp)
        Text(text = from, fontSize = 24.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CodeLab1Theme {
        BirthdayGreetingWithText(message = "Happy Birthday Sam", from = "- from emma")
    }
}