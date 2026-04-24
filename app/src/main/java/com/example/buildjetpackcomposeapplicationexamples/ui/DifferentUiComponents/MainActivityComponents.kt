package com.example.buildjetpackcomposeapplicationexamples.ui.DifferentUiComponents

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.buildjetpackcomposeapplicationexamples.Data.Models.FirstApiResponseModelItem
import com.example.buildjetpackcomposeapplicationexamples.ui.theme.BuildJetpackComposeApplicationExamplesTheme


class MainActivityComponents : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            setupExpressAndMetroUI()
        }
    }
}

@Composable
fun setupExpressAndMetroUI(navController: NavHostController) {
    var isClick by rememberSaveable { mutableStateOf(true) }
    Row {
        Button(
            onClick = {
                isClick = true
                navController.navigate("express")
            }, colors = ButtonDefaults.buttonColors(
                containerColor = if (isClick) Color(0XFF6A5AE0) else Color.LightGray,
                contentColor = if (isClick) Color.White else Color.White
            ), modifier = Modifier
                .weight(1f)
                .height(60.dp)
                .padding(5.dp)
        ) {
            Text("Express")
        }
        Spacer(Modifier.padding(5.dp))
        Button(
            onClick = {
                isClick = false
                navController.navigate("metro")
            }, colors = ButtonDefaults.buttonColors(
                containerColor = if (!isClick) Color(0XFF6A5AE0)  else  Color.LightGray,
                contentColor = if (!isClick) Color.White else Color.White
            ), modifier = Modifier
                .weight(1f)
                .height(60.dp)
                .padding(5.dp)
        ) {
            Text("Metro")
        }
    }

}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "express") {
        composable("express") {
            expressLayout()
        }
        composable("metro") {
            metroScreen()
        }
    }
}

@SuppressLint("ComposableNaming")
@Preview(showBackground = true)
@Composable
fun expressLayout() {
    Card( modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
            bottomStart = 20.dp,
            bottomEnd = 20.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )) {


    }

}

@SuppressLint("ComposableNaming")
@Composable
private fun metroScreen() {
    Text("metro Layout")
}

