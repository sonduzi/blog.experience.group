package com.example.blog_experiencegroup_project.ui.screens

import android.annotation.SuppressLint
import android.app.Fragment
import android.hardware.camera2.params.RecommendedStreamConfigurationMap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.blog_experiencegroup_project.R
import com.example.blog_experiencegroup_project.ui.component.MyAppFooter
import com.example.blog_experiencegroup_project.ui.components.RecommendedReviewList
import com.example.blog_experiencegroup_project.ui.components.RelatedReviewList
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ReviewDetailScreen() {
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFF16D6D),
                        shape = RoundedCornerShape(
                            topStart = 20.dp, topEnd = 20.dp, bottomStart = 0.dp, bottomEnd = 0.dp
                        )
                    )
            ){
                Text(
                    text = "캠페인 신청하기",
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
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
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "캠페인 안내",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                        )
                        Image(
                            painter = painterResource(id = R.drawable.baseline_navigate_before_24),
                            contentDescription = "null",
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .clickable {
                                    //navController.navigateUp()
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.baseline_home_24),
                            contentDescription = "null",
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .clickable {
                                    //navController.navigateUp()
                                }
                        )
                    }
                    HorizontalLine()
                    Spacer(modifier = Modifier.height(5.dp))
                    Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp)){
                        Text(
                            text= "롯데 상품권",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text= "롯데상품권 (30만원)",
                            fontSize = 15.sp,
                        )
                        Row(
                            modifier = Modifier
                            .padding(top = 5.dp)
                        ){
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Color(0xFFF16D6D),
                                        shape = RoundedCornerShape(5.dp)
                                    )
                                    .padding(2.dp)
                            ) {
                                Text(
                                    text = "Blog",
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(3.dp))
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Color(0xFFEEEEEE),
                                        shape = RoundedCornerShape(5.dp)
                                    )
                                    .padding(2.dp)
                            ) {
                                Text(
                                    text = "배송형",
                                    color = Color(0xFF757575),
                                    textAlign = TextAlign.Center,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }
                    Row(
                       modifier = Modifier.fillMaxWidth()
                    ){
                        Column(
                           modifier = Modifier.padding(16.dp)
                        ){
                            Text(
                                text = "리뷰어 신청기간",
                                fontWeight = FontWeight.Bold
                            )
                            Text("리뷰어 발표")
                            Text("리뷰 등록 기간")
                            Text("리뷰 등록 기간")
                        }
                        Column(
                            modifier = Modifier.padding(16.dp),
                        ){
                            Text(
                                text ="04.01~04.30",
                                fontWeight = FontWeight.Bold,
                                style = TextStyle(background = Color(0x41DFB5B5))
                            )
                            Text("05.01")
                            Text("05.02~05.31")
                            Text("06.01")
                        }
                        Box(
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.thumbnail2),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    HorizontalLine(10.dp)

                    Spacer(modifier = Modifier.height(20.dp))

                    ReviewTabLayout(
                        pagerState = pagerState
                    )
                }
            }
        }
    )
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun ReviewTabLayout(pagerState : PagerState) {
    val scope = rememberCoroutineScope()
    val tabs = listOf("캠페인 정보", "신청자")
    val context = LocalContext.current

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                color = Color(0xFFF16D6D)
            )
        },
        backgroundColor = Color.Transparent
    ) {
        tabs.forEachIndexed { index, title ->
            val selected = pagerState.currentPage == index
            Tab(
                modifier = Modifier
                    .padding(vertical = 15.dp),
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                selected = selected,
            ) {
                Text(
                    text = title,
                    color = if(selected) Color.Black else Color.Gray,
                    fontWeight = if(selected) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
    HorizontalPager(
        count = tabs.size,
        state = pagerState,
    ){
        index ->
        when(tabs[index]){
            "캠페인 정보" -> {
                CampaignInfoPage()
            }
            "신청자" -> {
                ApplicantPage()
            }
        }
    }
    RelatedReviewList()
    RecommendedReviewList()
    MyAppFooter()
}

@Composable
fun CampaignInfoPage(){
    val imageList = listOf(
        painterResource(id = R.drawable.reviewdetailthumb1),
        painterResource(id = R.drawable.reviewdetailthumb2),
        painterResource(id = R.drawable.reviewdetailthumb3),
        painterResource(id = R.drawable.reviewdetailthumb4)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        val rowCount = if(imageList.size % 2 ==0) imageList.size/2 else imageList.size/2 + 1
        for(i in 0 until rowCount){
            Row(){
                Image(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    painter = imageList[i * 2],
                    contentDescription = null,
                )
                if(imageList != null){
                    Image(
                        modifier = Modifier
                            .weight(1f)
                            .padding(5.dp),
                        painter = imageList[i * 2 + 1],
                        contentDescription = null,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                modifier = Modifier.padding(3.dp),
                text = "❚",
                color = Color(0xFFF16D6D)
            )
            Text(
                modifier = Modifier.padding(3.dp),
                text = "키워드"
            )
        }

        val keywordList = listOf("강남맛집 스페셜체험단 당첨 후기", "테스트용")
        Row(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            for (i in 0 until keywordList.size) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .background(
                            color = Color(0xFFEEEEEE),
                            shape = RoundedCornerShape(100.dp)
                        )
                ) {
                    Text(
                        text = keywordList[i],
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(10.dp),
            text = "- 키워드는 제목 1회, 본문 3회 이상 추가해 주세요.",
            color = Color(0xFFDADADA),
            fontSize = 12.sp,
        )
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalLine()

        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                modifier = Modifier.padding(3.dp),
                text = "❚",
                color = Color(0xFFF16D6D)
            )
            Text(
                modifier = Modifier.padding(3.dp),
                text = "제품 URL"
            )
        }

        Box(
            modifier = Modifier
                .padding(10.dp)
                .background(
                    color = Color(0xFF0377F4),
                    shape = RoundedCornerShape(100.dp)
                )
        ) {
            Text(
                text = "제품 보러가기>",
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 2.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(10.dp),
            text = "※ 정확한 URL을 확인해 주세요",
            color = Color(0xFFDADADA),
            fontSize = 12.sp,
        )
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalLine()

        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                modifier = Modifier.padding(3.dp),
                text = "❚",
                color = Color(0xFFF16D6D)
            )
            Text(
                modifier = Modifier.padding(3.dp),
                text = "가이드 라인"
            )
        }

        Text(
            modifier = Modifier.padding(10.dp),
            text = "★인스타, 페이스북 등 SNS에 함께 리뷰 가능하신 분들 선정 확률이 더 높습니다." +
                    "\n\n\n" + "★상품링크:https://smartstore.naver.com/(생략)" +"\n" + ">옵션에서 ...으로 구매해주세요" +
                    "★페이백 방식으로 진행됩니다.\n\n\n" + "★페이백 계좌의 입금자명, 상품 주문 시 주문자 성함, 강남맛집에 등록된 실명이 모두 동일해야 정상적으로 페이백이 진행됩니다. " +
                    "상품 주문, 리뷰등록 전 반드시 확인해주세요\n\n" + "★체험방법\n1)가이드에 따라 상품을 주문, 결제 후 배송 받아 체험해주세요." +
                    "\n2) 강남맛집에 리뷰를 등록하며 구매평 작성 계정, 계좌 정보를 남겨주시면 마감일 이후 일주일 내 순차적으로 페이백을 진행해드립니다.\n\n" +
                    "★알림받기, 상품찜, 사진을 포함한 구매평이 필수인 캠페인입니다. 구매평 작성 시 하단에 '해당 리뷰는 업체로부터 제품을 제공받아 직접 체험 후 솔직하게 작성한 리뷰입니다.'라는 문구를 반드시 기재해주세요."
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(10.dp),
            text = "※ 캠페일 미션이 지켜지지 않을 시 수정 요청이 있을 수 있습니다.",
            color = Color(0xFFDADADA),
            fontSize = 12.sp,
        )
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalLine()

        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                modifier = Modifier.padding(3.dp),
                text = "❚",
                color = Color(0xFFF16D6D)
            )
            Text(
                modifier = Modifier.padding(3.dp),
                text = "리뷰 시 주의사항"
            )
        }
        Text(
            modifier = Modifier.padding(10.dp),
            text = "1. 제공받은 제품으로 콘텐츠 용도 외 재판매는 절대 불가합니다.\n"
                    +"2. 재판매건 적발 시 제품 가격 환불 및 캠페인 참여 제한됩니다.\n"
                    +"3. 콘텐츠 등록기간 내 콘텐츠 미등록시 서비스이용료 및 제품 가격에 대하여 비용 청구됩니다.\n"
                    +"4. 콘텐츠 작성 시 지정된 키워드를 태그해 주세요\n"
                    +"5. 업체사정 또는 요청에 의해 선정 리뷰어 수 또는 캠페인 내용이 일부 변경될 수 있습니다.\n"
                    +"6. 동영상을 포함하여 사진은 최소 15장 이상 사용, 텍스트는 1,000자 이상 서술해주세요\n"
                    +"7. 리뷰 작성 시, 제목과 본문 내용에 지정된 키워드를 3회 이상 기재하고, 구매 링크를 첨부해주세요.\n"
        )

        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .background(
                    color = Color(0xFFEEEEEE)
                )
                .border(width = 1.dp, color = Color(0xFFBDBDBD))
        ){
            Row(modifier= Modifier.padding(15.dp)){
                Text(
                    text = "리뷰랜드의 위젯을 달면 선정확률 "
                )
                Text(
                    color = Color(0xFFF16D6D),
                    text = "Up! Up!"
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        HorizontalLine()

        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                modifier = Modifier.padding(3.dp),
                text = "❚",
                color = Color(0xFFF16D6D)
            )
            Text(
                modifier = Modifier.padding(3.dp),
                text = "Notice"
            )
        }

        Text(
            modifier = Modifier.padding(10.dp),
            text = "1. 리뷰랜드 이벤트의 원활한 진행을 위하여, 캠페인에 응모하신 리뷰어분들께 지역 맞춤 홍보 및 기타(광고)메일링 서비스를 제공합니다. " +
                    "해당 메일링 서비스는 가편히 수신거부 가능하며, 다만 수신 거부 시 거주지역 인근 캠페인 모집, 기타 이벤트 안내는 리뷰랜드.net 사이트 공지를 통해서만 확인 가능합니다.\n\n"
                    +"2. 본 체험 진행과 관련하여 작성된 블로그 후기의 내용(게시물에 포함된 문구, 사진, 동영상 등 제반 내용)은 제공된 상품 및 서비스와 결부된 광고물의 일종입니다. 따라서 체험 블로그 후기는 광고 목적 달성을 위해" +
                    "수집 편집 인용 등재가 될 수 있으며, 본 체험단 신청에 응모하시는 경우 위와 같은 내용에 간이하게 동의하신 것으로 안내드립니다.\n\n"
                    +"3. 체험단 후기는 거짓으로 작성되어서는 안되지만, 홍보의 목적으로 좋은 후기를 남기는 것이 주된 취지인만큼, 체험과정에서 문제점이 있으셨을 경우 따로 저희에게 1:1 문의를 통해 문제점을 남겨주시길 당부드립니다.\n\n" +
                    "감사합니다."
        )

        Spacer(modifier = Modifier.height(30.dp))
        HorizontalLine()
    }
}

@Composable
fun ApplicantPage(){
    Column(){
        for(i in 0 until 10){
            ApplicantItem()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp, vertical = 10.dp)
                .border(width = 1.dp, color = Color(0xFFBDBDBD))
        ){
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text ="더보기",
                fontSize = 15.sp
            )
        }
        HorizontalLine()
    }
}

@Composable
fun ApplicantItem(){
    Column(modifier = Modifier
        .padding(top = 16.dp, start = 10.dp, end = 10.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.no_profile),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text ="소히",
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                    Text(
                        text = "2024-04-06 14:10",
                        fontSize = 10.sp,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFFCFCFCF)
                    )
                }
                Text(
                    text = "신청 메세지는 신청자와 광고주만 확인 가능합니다.",
                    fontSize = 12.sp,
                    color = Color(0xFFCFCFCF)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalLine()
    }
}
@Preview
@Composable
fun DefaultPreview(){
    ApplicantPage()
}