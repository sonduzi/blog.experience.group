package com.example.blog_experiencegroup_project.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blog_experiencegroup_project.R

@Composable
fun CategoryScreen(navController: NavController){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ){
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "카테고리",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = "null",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable {
                        navController.navigateUp()
                    }
            )
        }
        HorizontalLine()

        var itemList = listOf("전체")
        CategoryItemList("홈", itemList)

        itemList = listOf("전체", "맛집", "뷰티", "숙박", "문화", "배달", "포장", "기타")
        CategoryItemList("지역", itemList)

        itemList = listOf("전체", "뷰티", "패션", "식품", "생활", "기타")
        CategoryItemList("제품", itemList)

        itemList = listOf("전체")
        CategoryItemList("기자단", itemList)

        itemList = listOf("전체")
        CategoryItemList("스페셜캠페인", itemList)

        itemList = listOf("전체")
        CategoryItemList("선정확률 높은 캠페인", itemList)

        HorizontalLine(5.dp)

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "고객센터",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))

            HorizontalLine()
            var csItemList = listOf("공지사항", "FAQ", "1:1문의", "강남맛집 이용가이드")
            for (i in 0 until csItemList.size) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                ) {
                    Text(
                        text = csItemList[i],
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                    )
                    Image(
                        painter = painterResource(id = R.drawable.baseline_navigate_next_24),
                        contentDescription = "null",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                    )
                }
                HorizontalLine()
            }
        }
    }
}

@Composable
fun CategoryItemList(title : String, subItemList : List<String>){
    Column(
        modifier = Modifier.padding(16.dp)
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        HorizontalLine()
        
        val rowCount = 
            if(subItemList.size %2 == 0) 
                subItemList.size/2 
            else 
                subItemList.size/2+1
        
        for (i in 0 until rowCount) {
            Row(){
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp),
                    text = subItemList[i*2],
                    fontSize = 15.sp,
                )
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(40.dp)
                        .background(Color(0xFFE7E7E7))
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp),
                    text = if(i*2+1 == subItemList.size) "" else subItemList[i*2+1],
                    fontSize = 15.sp,
                )
            }
            HorizontalLine()
        }
    }
}

@Composable
fun HorizontalLine(height : Dp = 1.dp){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(Color(0xFFE7E7E7))
    )
}

/*
@Preview
@Composable
fun DefaultPreview(){
    CategoryScreen()
}*/
