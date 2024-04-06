package com.example.blog_experiencegroup_project.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blog_experiencegroup_project.R.*
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blog_experiencegroup_project.R


@Composable
fun ReviewItemList(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(16.dp)
    )
    val itemList = listOf(
        ReviewItem(
            "LG 코드제로 오브제컬렉션 R9 로봇청소기",
            "LG 코드제로 오브제컬렉션 R9 로봇청소기(정가 139만원)",
            drawable.thumbnail1,
            4342,
            1
        ),
        ReviewItem(
            "롯데상품권",
            "롯데상품권(30만원)",
            drawable.thumbnail2,
            3058,
            1
        ),
        ReviewItem(
            "혜화로456",
            "3만원 상당 모나카, 오란다 배송체험권",
            drawable.thumbnail3,
            969,
            20
        ),
        ReviewItem(
            "[서울마포] 크레미뇽",
            "12구선물세트+6구선물세트 배송 체험권",
            drawable.thumbnail4,
            753,
            10
        )
    )
    Column(
        Modifier.padding(horizontal = 16.dp)
    ) {
        val size: Int = itemList.size / 2
        val isOddSize: Boolean = itemList.size % 2 != 0

        for (i in 0 until size) {
            Row(
            ) {
                if((i == size -1) && (isOddSize)){
                    ReviewItemView(itemList[i])
                } else{
                    ReviewItemView(itemList[i])
                    ReviewItemView(itemList[i+1])
                }
            }
        }
        Button(
            onClick = {},
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF5F5F5)),
            border = BorderStroke(1.dp, Color(0xFFD1D1D1)),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp
            )
        ){
            Text(
                text ="더보기",
                fontSize = 10.sp
            )
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "null",
                tint = Color.Gray
            )
        }
    }
}


@Composable
fun RowScope.ReviewItemView(item: ReviewItem) {
    Column(
        modifier = Modifier
            .weight(1f)
            .padding(5.dp)
            .clickable(onClick = {

            }),
    ) {
        Image(
            painter = painterResource(id = item.imageResourceId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(){
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFF16D6D),shape = RoundedCornerShape(2.dp))
                    .padding(2.dp)
            ) {
                Text(
                    text = "Blog",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(1.dp)
                )
            }
            Spacer(modifier = Modifier.width(3.dp))
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFEEEEEE),shape = RoundedCornerShape(2.dp))
                    .padding(2.dp)
            ) {
                Text(
                    text = "배송형",
                    color = Color(0xFF757575),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(1.dp)
                )
            }
            Spacer(modifier = Modifier.width(1.dp))
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFFFFFFF))
                    .padding(2.dp)
            ) {
                Text(
                    text = "14일 남음",
                    color = Color(0xFF585858),
                    fontSize = 10.sp
                )
            }
        }
        Text(
            text = item.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold // Bold 처리
        )
        Text(
            text = item.subTitle,
            maxLines = 1,
            fontSize = 10.sp,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(){
            Text(
                text = "신청 "+ item.subCount,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )
            Text(text = " / 모집" + item.totalCount, fontSize = 10.sp,)
        }
    }
}

data class ReviewItem(
    val title: String,
    val subTitle : String,
    val imageResourceId: Int,
    val subCount: Int,
    val totalCount : Int
)

