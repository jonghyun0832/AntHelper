package com.example.presentation.ui.component.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.theme.AntHelperTheme
import com.example.presentation.theme.Dimens

@Composable
fun OutlinedSingleTextField(
    input: String,
    onValueChange: (String) -> Unit,
    labelString: String,
    maxLength: Int = Int.MAX_VALUE,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.PaddingMedium)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = input,
            onValueChange = onValueChange,
            label = { Text(text = labelString) },
            shape = MaterialTheme.shapes.extraLarge,
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onBackground,
                focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = Color.Transparent
            ),
            isError = input.length > maxLength
        )

        if (maxLength != Int.MAX_VALUE) {
            Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall))

            Text(
                text = "${input.length}/$maxLength",
                style = MaterialTheme.typography.bodySmall,
                color = if (input.length > maxLength) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Preview(name = "OutlinedSingleTextFieldWithNoLimit")
@Composable
fun PreviewOutlinedTextFieldWithNoLimit() {
    AntHelperTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            OutlinedSingleTextField("test1", {}, "testLabel")
        }
    }
}

@Preview(name = "OutlinedSingleTextFieldWithLimit")
@Composable
fun PreviewOutlinedTextFieldWithLimit() {
    AntHelperTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            OutlinedSingleTextField("testsesafwjqidwiddwd", {}, "testLabel", 20)
        }
    }
}