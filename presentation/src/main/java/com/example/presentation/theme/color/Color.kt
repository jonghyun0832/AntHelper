package com.example.presentation.theme.color

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val BrandPrimary = Color(0xFF6750A4)
val BrandPrimaryLight = Color(0xFF9A82DB)
val BrandPrimaryDark = Color(0xFF381E72)

val BrandSecondary = Color(0xFF625B71)
val BrandSecondaryLight = Color(0xFF8B8499)
val BrandSecondaryDark = Color(0xFF3D3848)

val BrandBackground = Color(0xFFFFFBFE)
val BrandSurface = Color(0xFFFFFBFE)
val BrandError = Color(0xFFBA1A1A)

val BrandBackgroundDark = Color(0xFF1C1B1F)
val BrandSurfaceDark = Color(0xFF1C1B1F)
val BrandErrorDark = Color(0xFFFFB4AB)

val LightColorScheme = lightColorScheme(
    primary = BrandPrimary,
    onPrimary = Color.White,
    primaryContainer = BrandPrimaryLight,
    onPrimaryContainer = BrandPrimaryDark,

    secondary = BrandSecondary,
    onSecondary = Color.White,
    secondaryContainer = BrandSecondaryLight,
    onSecondaryContainer = BrandSecondaryDark,

    background = BrandBackground,
    onBackground = Color(0xFF1C1B1F),
    surface = BrandSurface,
    onSurface = Color(0xFF1C1B1F),

    error = BrandError,
    onError = Color.White
)

val DarkColorScheme = darkColorScheme(
    primary = BrandPrimaryLight,
    onPrimary = BrandPrimaryDark,
    primaryContainer = BrandPrimaryDark,
    onPrimaryContainer = BrandPrimaryLight,

    secondary = BrandSecondaryLight,
    onSecondary = BrandSecondaryDark,
    secondaryContainer = BrandSecondaryDark,
    onSecondaryContainer = BrandSecondaryLight,

    background = BrandBackgroundDark,
    onBackground = Color(0xFFE6E1E5),
    surface = BrandSurfaceDark,
    onSurface = Color(0xFFE6E1E5),

    error = BrandErrorDark,
    onError = Color(0xFF690005)
)


val extendedColorLight = ExtendedColors(
    myExtendColor1 = Color(0xFFFFFFFF),
    myExtendColor2 = Color(0xFF00FFFF),
    myExtendColor3 = Color(0xFFFF00FF),
    myExtendColor4 = Color(0xFFFFFF00)
)

val extendedColorDark = ExtendedColors(
    myExtendColor1 = Color(0xFF000000),
    myExtendColor2 = Color(0xFFFF0000),
    myExtendColor3 = Color(0xFF00FF00),
    myExtendColor4 = Color(0xFF0000FF)
)