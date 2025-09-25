package com.example.data.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class StockInterceptor(
    private val tokenProvider: TokenProvider
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()
        val newRequestBuilder = originRequest.newBuilder()

        newRequestBuilder
            .addHeader("Content-Type", "application/json;charset=UTF-8")


        tokenProvider.getTokenBlocking()?.let { token ->
            newRequestBuilder.addHeader("authorization", "Bearer $token")
        }

        val request = newRequestBuilder.build()
        val response = chain.proceed(request)

        if (response.code == 401) {
            // Token Expire
            Log.d("HttpInterceptor", "intercept: Token Expired")
        }

        return response
    }
}