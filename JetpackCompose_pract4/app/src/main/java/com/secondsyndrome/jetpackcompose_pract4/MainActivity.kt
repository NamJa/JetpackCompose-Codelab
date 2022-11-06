package com.secondsyndrome.jetpackcompose_pract4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.secondsyndrome.jetpackcompose_pract4.ui.theme.JetpackCompose_pract4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose_pract4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NameCard()
                }
            }
        }
    }
}

@Composable
fun NameCard() {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.weight(1f, true).wrapContentHeight(align = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = image, contentDescription = "android logo", modifier = Modifier.padding(start = 130.dp, end = 130.dp))
            Text(text = "Haaland", fontSize = 54.sp, color = Color.White, fontWeight = FontWeight.Light)
            Text(text = "Android Developer Extraordinaire", color = Color(0xFF3ddc84), fontWeight = FontWeight.Bold)
        }
        
        Column(
            modifier = Modifier.padding(bottom = 70.dp)
        ) {
            Contacts(Icons.Default.Phone, address = "+82 10-1234-1234")
            Contacts(Icons.Default.Share, address = "@Android")
            Contacts(Icons.Default.Email, address = "1234@1234example.com")
        }
    }
}

@Composable
fun Contacts(icon: ImageVector, address: String) {
    Row(modifier = Modifier.padding(start = 50.dp)) {
        Icon(icon, contentDescription = "phone", tint = Color(0xFF3ddc84))
        Spacer(modifier = Modifier.size(30.dp))
        Text(text = address, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackCompose_pract4Theme {
        NameCard()
    }
}