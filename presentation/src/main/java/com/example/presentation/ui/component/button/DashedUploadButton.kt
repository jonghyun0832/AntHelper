package com.example.presentation.ui.component.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.AntHelperTheme
import com.example.presentation.theme.Dimens

@Composable
fun DashedUploadButton(
    text: String,
    onClick: () -> Unit
) {
    val borderColor = MaterialTheme.colorScheme.onBackground
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = Dimens.PaddingExtraLarge)
            .drawBehind {
                val strokeWidth = 2.dp.toPx()
                val dashWidth = 12.dp.toPx()
                val dashGap = 6.dp.toPx()

                val paint = Paint().apply {
                    color = borderColor
                    style = PaintingStyle.Stroke
                    this.strokeWidth = strokeWidth
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashWidth, dashGap), 0f)
                }

                drawRoundRect(
                    color = borderColor,
                    size = size,
                    cornerRadius = CornerRadius(32f, 32f),
                    style = Stroke(width = strokeWidth, pathEffect = paint.pathEffect)
                )
            }
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = "Add Image Icon",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
            )
            Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall))
            Text(
                text = text,
                style = MaterialTheme.typography.displaySmall,
            )
        }
    }
}

@Preview
@Composable
fun PreviewDashedUploadButton() {
    AntHelperTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            DashedUploadButton("test") { }
        }
    }
}