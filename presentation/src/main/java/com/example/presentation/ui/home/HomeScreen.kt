package com.example.presentation.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.AntHelperTheme
import com.example.presentation.theme.extendedColors

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Theme Test1",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Theme Test2",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            text = "Theme Test3",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Text(
            text = "Theme Test4",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "Theme Test5",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Text(
            text = "Theme Test6",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Text(
            text = "Theme Test7",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.error
        )
        Text(
            text = "Theme Test8",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.extendedColors.myExtendColor1
        )
        Text(
            text = "Theme Test9",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.extendedColors.myExtendColor2
        )
    }
}

@Preview(name = "home light")
@Preview(name = "home dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewHomeScreen() {
    AntHelperTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen()
        }
    }
}