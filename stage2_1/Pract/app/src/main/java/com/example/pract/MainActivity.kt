package com.example.pract

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pract.ui.theme.PractTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PractTheme {
                MakeLemonAde(
                    Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun MakeLemonAde(modifier: Modifier = Modifier) {
    var lemonIndex by remember { mutableStateOf(0) }
    var squeezeCount by remember { mutableStateOf(1) }
    var lemonAdeGuide: Int = 0
    var lemonImage: Int = 0
    when(lemonIndex % 4) {
        0 -> {
            lemonAdeGuide = R.string.lemon_tree
            lemonImage = R.drawable.lemon_tree
        }
         1 -> {
             squeezeCount = (2..4).random()
             lemonAdeGuide = R.string.lemon_squeeze
             lemonImage = R.drawable.lemon_squeeze
         }
        2 -> {
            lemonAdeGuide = R.string.lemon_drink
            lemonImage = R.drawable.lemon_drink
        }
        3 -> {
            lemonAdeGuide = R.string.lemon_restart
            lemonImage = R.drawable.lemon_restart
        }
    }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = lemonAdeGuide), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if(lemonIndex % 4 == 1) {
                        squeezeCount -= 1
                        Log.d("MainActivity", squeezeCount.toString())
                        if(squeezeCount == 0)
                            lemonIndex += 1
                    } else {
                        lemonIndex += 1
                    }
                },
                shape = RoundedCornerShape(dimensionResource(id = androidx.core.R.dimen.compat_button_inset_vertical_material)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background)
            ) {
                Image(
                    painter = painterResource(id = lemonImage),
                    contentDescription = "",
                    modifier = Modifier.border(1.dp, color = Color.Cyan),
                )
            }
    }
}
