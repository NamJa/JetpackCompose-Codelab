package com.secondsyndrome.jetpackcompose_pract1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.secondsyndrome.jetpackcompose_pract1.ui.theme.JetpackCompose_pract1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose_pract1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    composeDisplay()
                }
            }
        }
    }
}

@Composable
fun composeDisplay() {
    Column {
        BannerWithImage()
        Title(message = "Jetpack Compose tutorial")
        Contents(content1 = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            content2 = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.")
    }

}

@Composable
fun BannerWithImage() {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(painter = image,contentDescription = "banner")
}

@Composable
fun Title(message: String) {
    Text(text = message,fontSize = 24.sp, modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp))
}

@Composable
fun Contents(content1: String, content2: String) {
    Column {
        Text(text = content1, modifier = Modifier.padding(start = 16.dp, end = 16.dp), textAlign = TextAlign.Justify)
        Text(text = content2, modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackCompose_pract1Theme {
        composeDisplay()
    }
}