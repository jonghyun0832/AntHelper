package com.example.presentation.ui.chart

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.presentation.R
import com.example.presentation.model.ChartModel
import com.example.presentation.theme.Dimens
import com.example.presentation.theme.buttonHeadlineMedium
import com.example.presentation.ui.component.button.DashedUploadButton
import com.example.presentation.ui.component.textfield.OutlinedSingleTextField
import com.example.presentation.viewmodel.chart.ChartEnrollAction
import com.example.presentation.viewmodel.chart.ChartEnrollEvent
import com.example.presentation.viewmodel.chart.ChartEnrollViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ChartEnrollScreen(
    chart: ChartModel? = null,
    navHostController: NavHostController,
    viewModel: ChartEnrollViewModel = hiltViewModel<ChartEnrollViewModel>()
) {
    val titleInput by viewModel.chartTitle.collectAsState()
    val photoUri by viewModel.imageUri.collectAsState()
    val context = LocalContext.current

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri: Uri? ->
            viewModel.updateImageUri(uri)
        }
    )

    LaunchedEffect(Unit) {
        viewModel.updateChartTitle(chart?.title.orEmpty())

        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                ChartEnrollEvent.OpenGallery -> {
                    photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                }
                ChartEnrollEvent.CompleteEnroll -> {
                    Toast.makeText(context, "등록이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                    navHostController.popBackStack()
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedSingleTextField(
            input = titleInput,
            onValueChange = { viewModel.updateChartTitle(it) },
            labelString = "종목명을 입력해주세요",
            maxLength = 20
        )
        Spacer(modifier = Modifier.height(Dimens.PaddingExtraLarge))
        if (photoUri == null) {
            DashedUploadButton(
                text = "사진 업로드",
                onClick = { viewModel.dispatch(ChartEnrollAction.ClickUploadImage) }
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = Dimens.PaddingExtraLarge)
                    .clickable { viewModel.dispatch(ChartEnrollAction.ClickUploadImage) }
            ) {
                AsyncImage(
                    model = photoUri,
                    contentDescription = "Selected Photo",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.large),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.product_image),
                    error = painterResource(R.drawable.product_image),
                )
                IconButton(
                    onClick = { viewModel.updateImageUri(null) },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Box(
                        modifier = Modifier
                            .size(Dimens.PaddingLarge)
                            .background(
                                color = MaterialTheme.colorScheme.surface,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Delete Photo",
                            modifier = Modifier.size(Dimens.IconSizeExtraSmall)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { viewModel.dispatch(ChartEnrollAction.ClickEnrollChart) },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            enabled = ((titleInput.isNotEmpty()) && (photoUri != null)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.PaddingMedium, vertical = Dimens.PaddingLarge)
        ) {
            Text(
                text = "등록하기",
                style = MaterialTheme.typography.buttonHeadlineMedium
            )
        }
    }
}