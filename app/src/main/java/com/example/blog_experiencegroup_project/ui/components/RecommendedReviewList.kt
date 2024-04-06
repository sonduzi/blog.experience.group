package com.example.blog_experiencegroup_project.ui.components

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blog_experiencegroup_project.R

@Composable
fun RecommendedReviewList(){
    val itemList = listOf(
        RecommendedReview(
            thumbnail = R.drawable.thumbnail1,
            type = "배송형",
            title = "타이틀타이틀타이틀타이틀타이틀타이틀타이틀",
            subTitle = "내용내용내용내용내용내용내용내용내용",
            remainDate = 24,
            applicateCount = 2296,
            availableCount = 1
        ),
        RecommendedReview(
            thumbnail = R.drawable.thumbnail2,
            type = "배송형",
            title = "타이틀타이틀타이틀타이틀타이틀타이틀타이틀",
            subTitle = "내용내용내용내용내용내용내용내용내용",
            remainDate = 24,
            applicateCount = 2168,
            availableCount = 1
        ),
        RecommendedReview(
            thumbnail = R.drawable.thumbnail3,
            type = "기자단",
            title = "타이틀타이틀타이틀타이틀타이틀타이틀타이틀",
            subTitle = "내용내용내용내용내용내용내용내용내용",
            remainDate = 2,
            applicateCount = 32,
            availableCount = 20
        ),
        RecommendedReview(
            thumbnail = R.drawable.thumbnail4,
            type = "배송형",
            title = "타이틀타이틀타이틀타이틀타이틀타이틀타이틀",
            subTitle = "내용내용내용내용내용내용내용내용내용",
            remainDate = 1,
            applicateCount = 518,
            availableCount = 30
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEEEEEE))

    ){
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(
                text = " 추천캠페인",
                fontSize = 20.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End

            ){
                Image(
                    painter = painterResource(id = R.drawable.baseline_navigate_before_24),
                    contentDescription = "null",
                )
                Spacer(modifier = Modifier.width(5.dp))
                Image(
                    painter = painterResource(id = R.drawable.baseline_navigate_next_24),
                    contentDescription = "null",
                )
            }
        }
        LazyRow(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 16.dp)
        ) {
            items(itemList) { item->
                RecommendedReviewItem(item)
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun RecommendedReviewItem(item : RecommendedReview){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val ColumnWidth = (screenWidth - 32) / 2

    Column(
        modifier = Modifier
            .width(ColumnWidth.dp)
    ){
        Column(
            modifier = Modifier
                .padding(5.dp)
        ){
            Image(
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop,
                painter = painterResource(item.thumbnail),
                contentDescription = null
            )
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFFFFFFF),shape = RoundedCornerShape(2.dp))
                    .padding(2.dp)
            ) {
                Text(
                    text = item.type,
                    color = Color(0xFF8F8F8F),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(1.dp)
                )
            }
        }

        Text(
            modifier = Modifier.padding(5.dp),
            text = item.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = item.subTitle,
            fontSize = 10.sp,
            maxLines = 1,
            color = Color(0xFF8F8F8F),
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier.padding(5.dp),
        ){
            Text(
                text = "${item.remainDate}일 남음",
                fontSize = 10.sp,
                color = Color(0xFF8F8F8F)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "신청 ${item.applicateCount}/${item.availableCount}명",
                fontSize = 10.sp,
                color = Color(0xFF8F8F8F)
            )
        }
    }
}

data class RecommendedReview(
    val thumbnail: Int,
    val type : String,
    val title : String,
    val subTitle: String,
    val remainDate: Int,
    val applicateCount : Int,
    val availableCount : Int
)

@Preview
@Composable
fun DefaultPreview3(){
    RecommendedReviewList()
}