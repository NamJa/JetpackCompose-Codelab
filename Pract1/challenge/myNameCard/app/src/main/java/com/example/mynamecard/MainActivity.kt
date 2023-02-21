package com.example.mynamecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynamecard.ui.theme.MyNameCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNameCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onSurface
                ) {
                    MyNameCard()
                }
            }
        }
    }
}

@Composable
fun MyNameCard() {
    Title()
    Contents()
}

@Composable
fun Title() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "logo",
            modifier = Modifier.padding(start = 130.dp, end = 130.dp)
        )
        Text(
            text = "Jongwoo Kim",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color.White
        )
        Text(
            text = "Android Developer Extraordinaire",
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun Contents() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 60.dp, end = 30.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                Icons.Filled.Phone, contentDescription = "phone Icon",
                modifier = Modifier.weight(1f), tint = Color(0xFF3ddc84)
            )
            Text(
                text = "+82 010-1111-0000", textAlign = TextAlign.Justify,
                modifier = Modifier.weight(1f), fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                Icons.Filled.Share, contentDescription = "Share Icon",
                modifier = Modifier.weight(1f), tint = Color(0xFF3ddc84)
            )
            Text(
                text = "@socialMedial Handle", textAlign = TextAlign.Justify,
                modifier = Modifier.weight(1f), fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                Icons.Filled.Email, contentDescription = "Email Icon",
                modifier = Modifier.weight(1f), tint = Color(0xFF3ddc84)
            )
            Text(
                text = "email@domain.com", textAlign = TextAlign.Justify,
                modifier = Modifier.weight(1f), fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun GreetingPreview() {
    MyNameCardTheme {
        MyNameCard()
    }
}