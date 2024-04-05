package com.example.blog_experiencegroup_project.ui.screens

import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blog_experiencegroup_project.R
import com.example.blog_experiencegroup_project.ui.component.MyAppFooter
import com.example.blog_experiencegroup_project.ui.components.MyAppBottomAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FAQScreen(navController : NavController) {
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            MyAppBottomAppBar(
                onHomeClick = {
                    navController.navigate("Home")
                },
                onCategoryClick = {
                    navController.navigate("Category")
                },
                onAskClick = {
                    navController.navigate("FAQ")
                },
                onAdAskClick = { /*TODO*/ },
                onLoginClick = {
                    navController.navigate("Login")
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(bottom = it.calculateBottomPadding())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "FAQ",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    )
                    Image(
                        painter = painterResource(id = R.drawable.baseline_navigate_before_24),
                        contentDescription = "null",
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .clickable {
                                navController.navigateUp()
                            }
                    )
                }
                HorizontalLine()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFFF1F1F1))
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "기간을 반드시 준수 해 주셔야하며, 기본적으로 기간 연장은 불가 합니다. 단, 업체측과 예약 소통하여 연장 체험이 가능하다고 확정 되신 경우는 예외입니다." +
                                "\n\n★선정된 캠페인의 취소는 나의 캠페인 > 선정된 캠페인의 [체험불가취소] 버튼을 통해 취소요청해 주세요.",
                        fontSize = 10.sp,
                        color = Color(0xFFF16D6D)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                val FAQItemList1 = listOf("전체", "리뷰어모집", "리뷰어 선정", "캠페인참여")
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    for (i in 0 until FAQItemList1.size) {
                        Button(
                            modifier = Modifier
                                .padding(3.dp)
                                .height(30.dp)
                                .wrapContentSize(),
                            contentPadding = PaddingValues(5.dp),

                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFF1F1F1),
                                contentColor = Color.Black
                            )
                        ) {
                            Text(
                                modifier = Modifier.padding(1.dp),
                                text = FAQItemList1[i],
                                fontSize = 12.sp,
                            )
                        }
                    }
                }

                val FAQItemList2 = listOf("캠페인 등록", "캠페인 마감", "기타")
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    for (i in 0 until FAQItemList2.size) {
                        Button(
                            modifier = Modifier
                                .padding(3.dp)
                                .height(30.dp),
                            contentPadding = PaddingValues(5.dp),
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFF1F1F1),
                                contentColor = Color.Black
                            )
                        ) {
                            Text(
                                modifier = Modifier.padding(1.dp),
                                text = FAQItemList2[i],
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(16.dp),
                ) {
                    var text by remember { mutableStateOf("") }
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        label = {
                            Text(
                                text = "검색어를 입력하세요",
                                style = TextStyle(
                                    fontSize = 12.sp, // 라벨의 글꼴 크기 변경
                                    color = Color.LightGray // 라벨의 색상 변경
                                ),
                                modifier = Modifier.align(Alignment.Center)
                            )
                        },
                        maxLines = 1,
                        trailingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_search_24), // 이미지 리소스 추가
                                contentDescription = "Image"
                            )
                        },
                        modifier = Modifier
                            .align(Alignment.BottomEnd),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                        )// 배경색 변경
                    )
                }

                HorizontalLine()

                // FAQ DB 로 전달 받아야함.
                // 1. Question, 2. Answer, 3. type
                FAQItemList()
                FAQItemList()
                FAQItemList()
                FAQItemList()
                FAQItemList()
                FAQItemList()
                FAQItemList()

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFFF1F1F1))
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "FAQ 카테고리에서 원하시는 내용이 없는 경우에만 1:1문의가 가능합니다.",
                        fontSize = 10.sp,
                        color = Color(0xFFF16D6D)
                    )
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "1:1 문의하기",
                        fontSize = 10.sp,
                        color = Color(0xFF000000)
                    )
                }

                MyAppFooter()
            }
        }
    )
}

@Composable
fun FAQItemList(){
    var visible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { visible = !visible},
    ) {
        Text(
            text = "[회원정보] 관심 지역 변경은 어떻게 하나요?",
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            modifier = Modifier.align(Alignment.CenterStart)
        )
        Image(
            painter = painterResource(id = if(visible) R.drawable.baseline_arrow_drop_up_24 else R.drawable.baseline_arrow_drop_down_24),
            contentDescription = "null",
            modifier = Modifier
                .align(Alignment.CenterEnd)
        )
    }
    if(visible){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFF1F1F1))
        ){
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = "강남 맛집 홈페이지 좌측 중하단에 위치한 '내 맞춤 지역 캠페인'에서 수정 가능합니다.",
            )
        }
    }

    HorizontalLine()
}

/*
@Preview
@Composable
fun DefaultPreview(){
    FAQScreen()
}*/
