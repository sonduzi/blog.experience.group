package com.example.blog_experiencegroup_project.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blog_experiencegroup_project.R
import com.example.blog_experiencegroup_project.ui.component.MyAppFooter
import com.example.blog_experiencegroup_project.ui.components.LiveReviewList
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
                onCategoryClick = {
                    navController.navigate("Category")
                },
                onAskClick = {
                    navController.navigate("FAQ")
                },
                onAdAskClick = {
                    // 기획 후 구현 필요함.
                },
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
                                painter = painterResource(id = R.drawable.reviewland_logo),
                                contentDescription = "logo",
                                modifier = Modifier
                                    .width(136.dp)
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
                    ScrollableBanners(bannerType = 0)
                    ReviewItemList(title = "인기 캠페인")

                    ScrollableBanners(bannerType = 1)
                    ReviewItemList(title = "마감임박 캠페인")

                    Spacer(modifier = Modifier.height(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.middle_banner3),
                        contentDescription = "null",
                        modifier = Modifier.fillMaxWidth()
                    )
                    ReviewItemList(title = "새로운 캠페인")
                    LiveReviewList()

                    Spacer(modifier = Modifier.height(10.dp))
                    MyAppFooter()
                }
            }
        }
    )
}

@Composable
fun ScrollableBanners(bannerType : Int) {
    val mainBannerList = listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)
    val middleBannerList = listOf(R.drawable.middle_banner1, R.drawable.middle_banner2)
    var bannerList: List<Int>? = null;

    if(bannerType == 0){
        bannerList = mainBannerList
    }else{
        bannerList = middleBannerList
    }

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
        modifier = Modifier.padding(5.dp)
    ) {
        items(bannerList.size) { index ->
            if(bannerType == 0)
                MainBannerItem(imageResourceId = bannerList[index])
            else
                MiddleBannerItem(imageResourceId = bannerList[index])
        }
    }
}

@Composable
fun MainBannerItem(imageResourceId: Int) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(170.dp)
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = imageResourceId),
            contentDescription = "null",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(RoundedCornerShape(10.dp))
        )
    }
}

@Composable
fun MiddleBannerItem(imageResourceId: Int) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(100.dp)
            .padding(3.dp)
    ) {
        Image(
            painter = painterResource(id = imageResourceId),
            contentDescription = "null",
        )
    }
}