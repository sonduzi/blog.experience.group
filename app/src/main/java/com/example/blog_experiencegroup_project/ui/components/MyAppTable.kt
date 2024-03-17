package com.example.blog_experiencegroup_project.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyAppTable() {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Row(Modifier.background(Color(0xFFC4C4C4))) {
            TableCell(text = "목적", 30.dp)
            TableCell(text = "항목", 30.dp)
            TableCell(text = "보유 및 이용 기간", 30.dp)
        }
        Row(
            Modifier.fillMaxWidth()
        ) {
            TableCell(text = "이용자 식별 및\n본인여부 확인",45.dp)
            TableCell(text = "이메일 주소, 비밀번호",45.dp)
            TableCell(text = "회원탈퇴시까지",45.dp)
        }
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    dpValue: Dp
) {
    Box(
        Modifier
            .border(1.dp, Color(0xFFB9B9B9))
            .weight(1f)
            .height(dpValue)
            .padding(8.dp)
    ) {
        Text(
            text = text,
            color = Color(0xFF707070),
            fontSize = 10.sp, // 텍스트 크기 설정
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.Center)
        )
    }
}


@Preview
@Composable
fun DefaultPreview(){
    MyAppTable()
}