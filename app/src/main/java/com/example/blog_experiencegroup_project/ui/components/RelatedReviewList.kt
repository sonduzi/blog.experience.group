package com.example.blog_experiencegroup_project.ui.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blog_experiencegroup_project.R

@Composable
fun RelatedReviewList(){
    val itemList = listOf(
       RelatedReview(
            thumbnail = R.drawable.thumbnail1,
            title = "강릉고속터미널맛집 생바지락칼제비",
            profileImage = R.drawable.no_profile,
            profileName = "소진짱"
         ),
        RelatedReview(
            thumbnail = R.drawable.thumbnail2,
            title = "강릉 / 강릉교통맛집 / 강릉칼제비 맛집 / 강릉 파전맛집",
            profileImage = R.drawable.no_profile,
            profileName = "소히짱"
        ),
        RelatedReview(
            thumbnail = R.drawable.thumbnail3,
            title = "테스트테스트테스트테스트테스트테스트테스트테스트",
            profileImage = R.drawable.no_profile,
            profileName = "창민팜"
        ),
        RelatedReview(
            thumbnail = R.drawable.thumbnail4,
            title = "테스트테스트테스트테스트테스트테스트테스트테스트",
            profileImage = R.drawable.no_profile,
            profileName = "고구마며눌"
        )
    )
    Column(modifier = Modifier
        .padding(vertical = 30.dp, horizontal = 16.dp)){
        Text(
            text = "연관 리뷰",
            fontSize = 20.sp
        )
        LazyRow(
            modifier = Modifier
                .padding(vertical = 10.dp)
        ) {
            items(itemList) { item->
                RelatedReviewItem(item)
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun RelatedReviewItem(item : RelatedReview){
    Column(
        modifier = Modifier
            .width(120.dp)
            .padding(5.dp)
    ){
        Image(
            painter = painterResource(id = item.thumbnail),
            contentDescription = "null",
        )
        Text(
            modifier = Modifier.padding(vertical = 5.dp),
            text = item.title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = item.profileImage),
                contentDescription = "null",
            )
            Text(
                modifier = Modifier.padding(5.dp),
                text = item.profileName,
                fontSize = 10.sp,
                color = Color.LightGray
            )
        }
    }
}

data class RelatedReview(
    val thumbnail: Int,
    val title : String,
    val profileImage: Int,
    val profileName: String
)

@Preview
@Composable
fun DefaultPreview2(){
    RelatedReviewList()
}
