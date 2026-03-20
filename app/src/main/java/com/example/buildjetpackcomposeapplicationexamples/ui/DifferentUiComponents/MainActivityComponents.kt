package com.example.buildjetpackcomposeapplicationexamples.ui.DifferentUiComponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivityComponents : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setupExpressAndMetroUI()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun setupExpressAndMetroUI() {
    var isClick by remember { mutableStateOf(false) }
    Row {
        Button(
            onClick = {
                isClick = true
            }, colors = ButtonDefaults.buttonColors(
                containerColor = if (!isClick) Color.Red else Color.Blue, // Background color
                contentColor = if (!isClick) Color.White else Color.Black // Optional: Text/Icon color
            )
        ) {
            Text("Express")
        }
        Spacer(Modifier.padding(10.dp))
        Button(onClick = {
            isClick = false
        }) {
            Text("Metro")
        }
    }

}