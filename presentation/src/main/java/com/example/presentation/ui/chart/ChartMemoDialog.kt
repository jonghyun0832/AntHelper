package com.example.presentation.ui.chart

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ChartMemoDialog(
    userInput: String,
    onValueChange: (String) -> Unit,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "차트 메모"
            )
        },
        text = {
            BoxWithConstraints {
                val dialogHeight = maxHeight * 0.5f
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dialogHeight),
                    color = Color.Transparent
                ) {
                    OutlinedTextField(
                        value = userInput,
                        onValueChange = onValueChange,
                        placeholder = { Text("차트와 관련된 기록을 추가하세요") },
                        shape = MaterialTheme.shapes.large,
                        maxLines = 50,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = MaterialTheme.colorScheme.onBackground,
                            focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            focusedContainerColor = MaterialTheme.colorScheme.background,
                            unfocusedContainerColor = Color.Transparent
                        )
                    )
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = onConfirm
            ) {
                Text(text = "저장")
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(text = "취소")
            }
        }
    )
}