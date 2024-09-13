package com.solo4.cardgame.presentation.screens.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(navController: NavHostController) {

    val viewModel = koinViewModel<MenuViewModel>()
    var userName by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(value = userName, onValueChange = { userName = it })
        Button(onClick = viewModel::onConnectToLobbyClicked) {
            Text(text = "Присоединиться к лобби")
        }
    }
}