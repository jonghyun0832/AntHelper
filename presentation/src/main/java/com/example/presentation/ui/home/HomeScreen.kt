package com.example.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.theme.Dimens
import com.example.presentation.viewmodel.home.HomeViewModel

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(Dimens.PaddingMedium)
    ) {
        HomeIndexCard()
        Spacer(modifier = Modifier.height(Dimens.PaddingExtraLarge))
        HomeExchangeCard()
    }
}

@Composable
fun HomeIndexCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dimens.PaddingSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "지수 제목 및 실제 지수 표시 (미국, 한국)",
            modifier = Modifier
                .weight(1f)
                .padding(end = Dimens.PaddingSmall),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineMedium
        )

        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Reload Index"
            )
        }

    }
    Box(
        modifier = Modifier.fillMaxWidth().height(400.dp).background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "지수 흐름 차트 표시, 적어도 월 / 주 / 일 필터링은 있어야함"
        )
    }
}

@Composable
fun HomeExchangeCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dimens.PaddingSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "환율 표시 (한국, 미국, 일본, 유럽)",
            modifier = Modifier
                .weight(1f)
                .padding(end = Dimens.PaddingSmall),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineMedium
        )

        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Reload Exchange Rate"
            )
        }
    }
    Box(
        modifier = Modifier.fillMaxWidth().height(400.dp).background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "환율 흐름 차트 표시, 적어도 월 / 주 / 일 필터링은 있어야함"
        )
    }
}

// TODO : fastAPI 연결 / fastAPI에 RSI 지수 가져오기 / fastAPI에 환율 정보 가져오기 / 이전 RSI 지수, 환율 정보는 csv로 가져와서 직접 데이터베이스에 넣어주기 / 데이터베이스 연결 / 가져온 정보로 홈 화면 구현
