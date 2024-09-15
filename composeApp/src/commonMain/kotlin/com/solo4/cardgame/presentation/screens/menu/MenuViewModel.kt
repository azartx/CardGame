package com.solo4.cardgame.presentation.screens.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solo4.cardgame.data.repository.MenuRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MenuViewModel(private val menuRepository: MenuRepository) : ViewModel() {

    private val _userName = MutableStateFlow("")
    val userName = _userName.asStateFlow()

    init {
        viewModelScope.launch {
            menuRepository.openGameConnection()
                .collectLatest {
                    println(it)
                }
        }
    }

    fun onConnectToLobbyClicked() {
        viewModelScope.launch {
            menuRepository.connectToLobby(userName.value)
        }
    }

    fun onUserNameChanged(userName: String) {
        viewModelScope.launch { this@MenuViewModel._userName.emit(userName) }
    }
}