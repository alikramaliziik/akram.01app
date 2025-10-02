package com.example.akramapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.akramapp.ui.theme.AkramAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AkramAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TestLayout(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// your dice drawable IDs
private val imageIds = listOf(
    R.drawable.dice_1,
    R.drawable.dice_2,
    R.drawable.dice_3,
    R.drawable.dice_4,
    R.drawable.dice_5,
    R.drawable.dice_6
)

@Composable
fun TestLayout(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxSize()) {

        // Column 1: 6 dice stacked
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(150.dp)  // wider column to fit big dice
                .background(Color.Yellow),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            imageIds.forEachIndexed { index, id ->
                Image(
                    painter = painterResource(id = id),
                    contentDescription = "Dice ${index + 1}",
                    modifier = Modifier
                        .padding(6.dp)
                        .size(120.dp) // 🔴 bigger dice size here
                )
            }
        }

        // Column 2
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
                .background(Color.Gray)
        ) {
            // add content here
        }

        // Column 3
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
                .background(Color.Green)
        ) {
            // add content here
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTestLayout() {
    AkramAppTheme {
        TestLayout()
    }
}
