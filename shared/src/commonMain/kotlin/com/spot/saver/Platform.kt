package com.spot.saver

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform