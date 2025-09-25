package com.example.data.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthStockOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NoAuthStockOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthStockRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NoAuthStockRetrofit