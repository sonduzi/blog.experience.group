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
import androidx.compose.ui.unit.sp
import com.example.blog_experiencegroup_project.R

@Composable
fun MyAppFooter() {
    Column(
        modifier = Modifier
            .background(Color(0xFFF5F5F5))
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.reviewland_logo_black),
            contentDescription = "logo",
        )
        Spacer(modifier = Modifier.height(3.dp))

        Text("리뷰랜드 | 개인정보 보호 책임자 : 손소희")
        Text("사업자등록번호: 111-11-11111")
        Text("고객센터 : 1111-1111 | help@reviewland.net")
        Text("운영시간 : AM 9:00~PM 18:00 (점심시간 12:00~13:00")
        Text(
            text ="*주말 및 공휴일은 카카오 문의를 남겨주세요.",
            color = Color(0xFFA7A7A7),
            fontSize = 10.sp
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text("SINCE2024 © 리뷰랜드 Right Reserved")
    }
}