package com.solo4.cardgame

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform