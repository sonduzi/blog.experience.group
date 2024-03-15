package com.example.blog_experiencegroup_project.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blog_experiencegroup_project.R

@Composable
fun MyAppFooter() {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.reviewfactory_logo),
            contentDescription = "reviewfactorylogo",
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
        )
        Row(){
            Text("Tel : xxx-xxxx")
            Text("xxxxx@xxxx.com")
        }

        Spacer(modifier = Modifier.height(3.dp))

        Text("am 9:00 ~ pm 18:00")
        Text("리뷰팩토리 | 개인정보 보호 책임자 : 손소희")
        Text("사업자등록번호: xxx-xx-xxxxx")
        Text("전화권유판매업 : 제 XXXX-서울강남-XXXX 호")

        Spacer(modifier = Modifier.height(3.dp))

        Text("SINCE2024 © 리뷰팩토리 Corp. All Right Reserved")

        Row(){
            Text("서비스 이용약관")
            Text("개인정보처리방침")
            Text("광고문의")
        }
    }
}

@Preview
@Composable
fun DefaultPReview(){
    MyAppFooter()
}