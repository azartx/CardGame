package com.solo4.cardgame.di

import com.solo4.cardgame.data.repository.MenuRepository
import org.koin.dsl.module

internal val repositoryModule = module {
    factory { MenuRepository(get()) }
}