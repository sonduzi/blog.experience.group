package com.example.blog_experiencegroup_project.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blog_experiencegroup_project.R
import com.example.blog_experiencegroup_project.ui.component.MyAppFooter
import com.example.blog_experiencegroup_project.ui.components.MyAppBottomAppBar
import com.example.blog_experiencegroup_project.ui.components.ReviewItemList

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController : NavController){
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()
    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            MyAppBottomAppBar(
                onHomeClick = { /*TODO*/ },
                onCategoryClick = { /*TODO*/ },
                onAskClick = { /*TODO*/ },
                onAdAskClick = { /*TODO*/ },
                onLoginClick = {
                   navController.navigate("Login")
                }
            )
        },
        content = {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = it.calculateBottomPadding()) // 하단 패딩을 계산하여 content를 BottomAppBar 위로 밀어냄
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End, // 이미지를 오른쪽으로 정렬합니다.
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        // 첫 번째 이미지를 중앙 정렬합니다.
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                                .align(Alignment.CenterVertically)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chd),
                                contentDescription = "logo",
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(40.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        // 두 번째 이미지를 오른쪽으로 정렬합니다.
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .align(Alignment.CenterVertically)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_search_24),
                                contentDescription = "search Image",
                                modifier = Modifier
                                    .size(30.dp, 30.dp)
                            )
                        }
                    }
                    ScrollableBanners()

                    Text(
                        text = "인기 캠페인",
                        modifier = Modifier.padding(16.dp)
                    )
                    ReviewItemList()
                }
            }
        }
    )
}

@Composable
fun ScrollableBanners() {
    val bannerList = listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)

    var currentIndex by remember { mutableStateOf(0) }
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = currentIndex)

    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .collect { index ->
                currentIndex = index
                if (index == bannerList.size - 1) {
                    listState.scrollToItem(0)
                }
            }
    }

    LazyRow(
        state = listState,
        modifier = Modifier.padding(10.dp)
    ) {
        items(bannerList.size) { index ->
            BannerItem(imageResourceId = bannerList[index])
        }
    }
}

@Composable
fun BannerItem(imageResourceId: Int) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(170.dp)
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = imageResourceId),
            contentDescription = "null",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(RoundedCornerShape(10.dp))
        )
    }
}