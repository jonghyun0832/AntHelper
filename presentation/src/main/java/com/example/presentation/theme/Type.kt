package com.example.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.presentation.R

private val spoqaBold = FontFamily(
    Font(R.font.spoqa_han_sans_neo_bold, FontWeight.Bold)
)
private val spoqaRegular = FontFamily(
    Font(R.font.spoqa_han_sans_neo_regular, FontWeight.Normal)
)
private val spoqaThin = FontFamily(
    Font(R.font.spoqa_han_sans_neo_thin, FontWeight.Thin)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 60.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 32.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 24.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = spoqaThin,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 18.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 15.sp
    ),
    titleLarge = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 18.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 15.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 15.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 10.sp
    )
)

val Typography.headlineMediumTitle: TextStyle
    @Composable get() = headlineMedium.copy(
        fontSize = 24.sp
    )

val Typography.dialogButton: TextStyle
    @Composable get() = headlineMedium.copy(
        fontSize = 16.sp
    )

val Typography.underlinedDialogHeadlineMedium: TextStyle
    @Composable get() = headlineMedium.copy(
        textDecoration = TextDecoration.Underline
    )
