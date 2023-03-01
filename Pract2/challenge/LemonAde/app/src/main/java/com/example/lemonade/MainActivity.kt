package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonAdeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonAdeTheme {
                LemonAdeApp()
            }
        }
    }
}

@Composable
fun LemonAdeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LemonAdeRot(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        )
    }

}

@Composable
fun LemonAdeRot(modifier: Modifier = Modifier) {
    var lemonLevel by remember { mutableStateOf(0) }
    var lemonTapCnt by remember { mutableStateOf(1) }
    var lemonRndCnt by remember { mutableStateOf(0) }
    var isRndCalled by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(setLemonLevelText(lemonLevel)),
            fontSize = 18.sp
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Image(
            painter = painterResource(id = setLemonLevelImage(lemonLevel)),
            contentDescription = "1",
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = Color(red = 105, green = 205, blue = 216)
                )
                .clickable {
                    if ((lemonLevel % 4) == 1) {
                        if (!isRndCalled) {
                            isRndCalled = true
                            lemonRndCnt = (2..4).random()
                        }
                        if (lemonTapCnt <= lemonRndCnt) {
                            lemonTapCnt += 1
                        } else {
                            lemonTapCnt = 1
                            isRndCalled = false
                            lemonLevel += 1
                        }
                    } else {
                        lemonLevel += 1
                    }
                },
        )
    }
}

fun setLemonLevelText(lemonLevel: Int): Int {
    val lemonText = when (lemonLevel % 4) {
        0 -> R.string.first
        1 -> R.string.second
        2 -> R.string.third
        else -> R.string.fourth
    }
    return lemonText
}

fun setLemonLevelImage(lemonLevel: Int): Int {
    val lemonImage = when (lemonLevel % 4) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    return lemonImage
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonAdeTheme {
        LemonAdeApp()
    }
}