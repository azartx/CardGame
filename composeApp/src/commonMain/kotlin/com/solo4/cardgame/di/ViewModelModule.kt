package com.solo4.cardgame.di

import com.solo4.cardgame.presentation.screens.menu.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModelModule = module {
    viewModel { MenuViewModel(get()) }
}