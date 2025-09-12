package com.example.presentation.model

enum class ChartLocale {
    KR, US;
}

fun String.toChartLocale(): ChartLocale {
    return when (this) {
        "US" -> ChartLocale.US
        else -> ChartLocale.KR
    }
}

fun ChartLocale.toDomain(): String {
    return when (this) {
        ChartLocale.US -> "US"
        else -> "KR"
    }
}