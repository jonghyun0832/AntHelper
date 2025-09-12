package com.example.presentation.ui.chart

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BorderColor
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.model.ChartUiModel
import com.example.presentation.theme.Dimens

@Composable
fun ChartCard(
    chart: ChartUiModel,
    onChartClick: () -> Unit,
    onEditDescriptionClick: () -> Unit,
    onEditBookmarkClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(Dimens.PaddingSmall)
            .border(2.dp, MaterialTheme.colorScheme.primary, MaterialTheme.shapes.medium)
            .shadow(elevation = Dimens.PaddingExtraSmall),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        onClick = {} // TODO : 차트 상세화면으로 이동
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.PaddingMedium, vertical = Dimens.PaddingSmall)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = chart.title,
                    style = MaterialTheme.typography.headlineMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = Dimens.PaddingSmall)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingExtraSmall)
                ) {
                    IconButton(
                        onClick = onEditDescriptionClick
                    ) {
                        Icon(
                            imageVector = Icons.Filled.BorderColor,
                            contentDescription = "Bookmark Icon",
                        )
                    }
                    IconButton(
                        onClick = onEditBookmarkClick
                    ) {
                        Icon(
                            imageVector = if (chart.bookmark) Icons.Filled.Star else Icons.Filled.StarBorder,
                            contentDescription = "Bookmark Icon"
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(Dimens.PaddingSmall))
            Image(
                painter = painterResource(id = R.drawable.product_image),
                contentDescription = "Chart Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(RoundedCornerShape(12.dp))
            )
        }
    }
}