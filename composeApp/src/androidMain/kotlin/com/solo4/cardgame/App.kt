package com.solo4.cardgame

import android.app.Application
import com.solo4.cardgame.di.androidModule
import com.solo4.cardgame.di.commonModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                commonModule,
                androidModule,
            )
        }
    }
}