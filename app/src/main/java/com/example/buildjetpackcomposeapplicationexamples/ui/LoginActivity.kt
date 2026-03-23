package com.example.buildjetpackcomposeapplicationexamples.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buildjetpackcomposeapplicationexamples.R
import com.example.buildjetpackcomposeapplicationexamples.ui.ui.theme.BuildJetpackComposeApplicationExamplesTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuildJetpackComposeApplicationExamplesTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF7F3EF))
                        .verticalScroll(rememberScrollState())
                        .imePadding(),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            pictureFormation(120)
                        }

                        Spacer(modifier = Modifier.height(50.dp))
                        enterName()
                        Spacer(modifier = Modifier.height(10.dp))
                        enterPassword()
                        Spacer(modifier = Modifier.height(10.dp))
                        submitButton()
                        Spacer(modifier = Modifier.height(50.dp))
                    }
                }
            }
        }
    }
}



@Composable
fun pictureFormation(pictureSize : Int ) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.train_logo),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape).size(pictureSize.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun enterName() {
    var nameText by remember { mutableStateOf("") }
    TextField(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)
        .padding(vertical = 5.dp)
        .border(
            width = 1.dp,
            color = Color(0xFF0A1F44),
            shape = RoundedCornerShape(8.dp)
        ),
        value = nameText,
        onValueChange = { it -> nameText = it },
        label = { Text("Enter The Name") },
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedTextColor = Color.Black,
            focusedLabelColor = Color.Black
        )
    )
}

@Preview(showBackground = true)
@Composable
fun enterPassword() {
    var passwordText by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    TextField(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)
        .padding(vertical = 5.dp)
        .border(
            width = 1.dp,
            color = Color(0xFF0A1F44),
            shape = RoundedCornerShape(8.dp)
        ),
        value = passwordText,
        onValueChange = { it -> passwordText = it },
        label = { Text("Enter The Password") },
        shape = RoundedCornerShape(12.dp),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (isPasswordVisible) Icons.Default.Visibility
            else Icons.Default.VisibilityOff

            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(imageVector = image, contentDescription = null)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedTextColor = Color.Black,
            focusedLabelColor = Color.Black
        )
    )
}

@Preview(showBackground = true)
@Composable
fun submitButton() {
    val context = LocalContext.current
    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp),
        onClick = {
            callingApiForGettingLoginCredential(context)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor =  Color(0xFF0A1F44),
            contentColor = Color.White
        )
    ) {
        Text("Submit")
    }
}

fun callingApiForGettingLoginCredential(context: Context) {
    Toast.makeText(context, "The Button is Clicked", Toast.LENGTH_SHORT).show()
}