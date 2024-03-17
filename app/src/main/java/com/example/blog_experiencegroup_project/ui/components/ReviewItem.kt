package com.example.blog_experiencegroup_project.ui.components

import android.R.attr
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blog_experiencegroup_project.R
import androidx.compose.ui.text.style.TextOverflow


@Composable
fun ReviewItemList() {
    val itemList = listOf(
        ReviewItem(
            "LG 코드제로 오브제컬렉션 R9 로봇청소기",
            "LG 코드제로 오브제컬렉션 R9 로봇청소기(정가 139만원)",
            R.drawable.thumbnail1,
            4342,
            1
        ),
        ReviewItem(
            "롯데상품권",
            "롯데상품권(30만원)",
            R.drawable.thumbnail2,
            3058,
            1
        ),
        ReviewItem(
            "혜화로456",
            "3만원 상당 모나카, 오란다 배송체험권",
            R.drawable.thumbnail3,
            969,
            20
        ),
        ReviewItem(
            "[서울마포] 크레미뇽",
            "12구선물세트+6구선물세트 배송 체험권",
            R.drawable.thumbnail4,
            753,
            10
        )
    )
    Column(
        Modifier.padding(horizontal = 16.dp)
    ) {
        Row(
        ) {
            ReviewItemView(itemList[0])
            ReviewItemView(itemList[1])
        }
        Row(
        ) {
            ReviewItemView(itemList[2])
            ReviewItemView(itemList[3])
        }
    }
}


@Composable
fun RowScope.ReviewItemView(item: ReviewItem) {
    Column(
        modifier = Modifier
            .weight(1f)
            .padding(5.dp),
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
                     .background(color = Color(0xFFFF6F00))
             ) {
                 Text(
                     text = "Blog",
                     color = Color.White,
                     textAlign = TextAlign.Center
                 )
             }
            Spacer(modifier = Modifier.width(1.dp))
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFDADADA))
            ) {
                Text(
                    text = "배송형",
                    color = Color(0xFF979797),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(1.dp))
            Text(
                text = "14일 남음",
                color = Color(0xFF979797),
                textAlign = TextAlign.Center
            )
        }
        Text(
            text = item.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold // Bold 처리
        )
        Text(
            text = item.subTitle,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "신청 "+ item.subCount + " / 모집" + item.totalCount)
    }
}

@Preview
@Composable
fun DefaultPreview(){
    ReviewItemList()
}

data class ReviewItem(
    val title: String,
    val subTitle : String,
    val imageResourceId: Int,
    val subCount: Int,
    val totalCount : Int
)

