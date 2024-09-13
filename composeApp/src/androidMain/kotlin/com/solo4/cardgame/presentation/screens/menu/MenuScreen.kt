package com.solo4.cardgame.presentation.screens.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(navController: NavHostController) {

    val viewModel = koinViewModel<MenuViewModel>()
    val userName by viewModel.userName.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(value = userName, onValueChange = viewModel::onUserNameChanged)
        Button(onClick = viewModel::onConnectToLobbyClicked) {
            Text(text = "Присоединиться к лобби")
        }
        // TODO debug only, RM
        Button(onClick = viewModel::emulateOtherPlayers) { Text("Emulate connections") }
    }
}