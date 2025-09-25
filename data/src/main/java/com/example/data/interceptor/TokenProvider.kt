package com.example.data.interceptor

interface TokenProvider {
    fun getTokenBlocking(): String?
}