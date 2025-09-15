package com.example.presentation.ui.chart

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.presentation.R
import com.example.presentation.model.ChartModel
import com.example.presentation.theme.Dimens
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
    var titleInput by remember { mutableStateOf(chart?.title.orEmpty()) }
    val photoUri by viewModel.imageUri.collectAsState()

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri: Uri? ->
            viewModel.updateImageUri(uri)
        }
    )

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                ChartEnrollEvent.OpenGallery -> {
                    Log.d("tjwh", "ChartEnrollScreen: ")
                    photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedSingleTextField(
            input = titleInput,
            onValueChange = { titleInput = it },
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
    }
}