package com.example.myapplicationcoffee.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationcoffee.R


@Composable
fun Login(navController: NavHostController) {
    var nome by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .size(150.dp)
                .border(2.dp, Color.Black, CircleShape)
                .clip(CircleShape),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(150.dp),
                painter = painterResource(id = R.drawable.coffee),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp, end = 24.dp, start = 24.dp),
            value = nome,
            onValueChange = { textoDigitado ->
                nome = textoDigitado
            }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, end = 24.dp, start = 24.dp),
            value = nome,
            onValueChange = { textoDigitado ->
                nome = textoDigitado
            }
        )

        Button(
            onClick = {navController.navigate("coffeeActivity")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            colors = ButtonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.Unspecified
            )

        ) {
            Text(
                text = "Sign in",
            )
        }
    }
}

@Composable
fun CoffeeScreen() {
    CoffeeActivity()
}

@Composable
fun NavigationLoginToCoffeeActivity() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "coffeeActivity") {
        composable("login") { Login(navController) }
        composable("coffeeActivity") { CoffeeScreen() }
    }
}

@Preview()
@Composable
fun LoginPreview() {
    NavigationLoginToCoffeeActivity()
}