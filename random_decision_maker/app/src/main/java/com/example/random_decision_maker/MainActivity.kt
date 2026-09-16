package com.example.random_decision_maker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.random_decision_maker.ui.theme.Random_decision_makerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Random_decision_makerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DecisionScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DecisionScreen(modifier: Modifier = Modifier) {
    var clickCount by remember { mutableStateOf(0) }
    var resultText by remember { mutableStateOf(("Should we go? "))}

    //UI

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(resultText)

        Row() {
            Button(
                onClick = {
                    resultText = yesOrNo(75)
                    clickCount += 1
                }
            ) {
                Text("High 75%")
            }

            Button(
                onClick = {
                    resultText = yesOrNo(50)
                    clickCount += 1
                }
            ) {
                Text("Mid 50%")
            }

            Button (
                onClick = {
                    resultText = yesOrNo(25)
                    clickCount += 1
                }
            ) {
                Text("Low 25%")
            }

        }
        Text("Clicks: $clickCount")

        Text("Student ID: 1873440, CCID: akshatsi")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Random_decision_makerTheme {
        DecisionScreen()
    }
}

fun yesOrNo(percentage: Int): String {

    val ranNum = (0..100).random()

    if (ranNum > percentage) {
        return "No"
    }else if (ranNum < percentage) {
        return "Yes"
    }else{
        return "Maybe"
    }
}

