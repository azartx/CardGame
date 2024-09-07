package com.solo4.cardgame.di

import org.koin.dsl.module

val commonModule = module {
    includes(
        platformModule,
        networkModule,
    )
}