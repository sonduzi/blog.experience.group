package com.example.blog_experiencegroup_project.ui.components

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blog_experiencegroup_project.R

@Composable
fun LiveReviewList() {
    val itemList = listOf(
        LiveReview(
            R.drawable.thumbnail1,
            R.drawable.no_profile,
            "손쓰 일기1",
            "송파 무인테니스\n24시간 더테니스존 장지점",
            R.drawable.thum_no,
            "[서울 송파]"
        ),
        LiveReview(
            R.drawable.thumbnail2,
            R.drawable.no_profile,
            "손쓰 일기2",
            "송파 무인테니스\n24시간 더테니스존 장지점",
            R.drawable.thum_no,
            "[서울 송파] 더테니스존 장지점"
        ),
        LiveReview(
            R.drawable.thumbnail3,
            R.drawable.no_profile,
            "손쓰 일기3",
            "송파 무인테니스\n24시간 더테니스존 장지점",
            R.drawable.thum_no,
            "[서울 송파] 더테니스존 장지점"
        ),
        LiveReview(
            R.drawable.thumbnail1,
            R.drawable.no_profile,
            "손쓰 일기1",
            "송파 무인테니스\n24시간 더테니스존 장지점",
            R.drawable.thum_no,
            "[서울 송파] 더테니스존 장지점"
        ),
        LiveReview(
            R.drawable.thumbnail2,
            R.drawable.no_profile,
            "손쓰 일기2",
            "송파 무인테니스\n24시간 더테니스존 장지점",
            R.drawable.thum_no,
            "[서울 송파] 더테니스존 장지점"
        ),
        LiveReview(
            R.drawable.thumbnail3,
            R.drawable.no_profile,
            "손쓰 일기3",
            "송파 무인테니스\n24시간 더테니스존 장지점",
            R.drawable.thum_no,
            "[서울 송파] 더테니스존 장지점"
        ),
        LiveReview(
            R.drawable.thumbnail1,
            R.drawable.no_profile,
            "손쓰 일기1",
            "송파 무인테니스\n24시간 더테니스존 장지점",
            R.drawable.thum_no,
            "[서울 송파] 더테니스존 장지점"
        ),
        LiveReview(
            R.drawable.thumbnail2,
            R.drawable.no_profile,
            "손쓰 일기2",
            "송파 무인테니스\n24시간 더테니스존 장지점",
            R.drawable.thum_no,
            "[서울 송파] 더테니스존 장지점"
        ),
        LiveReview(
            R.drawable.thumbnail3,
            R.drawable.no_profile,
            "손쓰 일기3",
            "송파 무인테니스\n24시간 더테니스존 장지점",
            R.drawable.thum_no,
            "[서울 송파] 더테니스존 장지점"
        ),
    )
    Column(

    ){
        Text(
            text = "실시간 리뷰",
            modifier = Modifier.padding(16.dp)
        )
        LazyRow(
        ) {
            items(itemList) { item->
                LiveReviewItem(item)
            }
        }
        Row(
            modifier = Modifier
                .align(CenterHorizontally)
        ){
            val count : Int= 4
            for(i in 0 until count){
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(color = Color.LightGray)
                )
            }
        }
    }
}


@Composable
fun LiveReviewItem(item: LiveReview){
    Column(
        modifier = Modifier
            .width(120.dp)
            .padding(15.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.thumbnail1),
            contentDescription = "null"
        )
        Row(
            modifier = Modifier.padding(2.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.no_profile),
                contentDescription = "null",
            )
            Box(
                modifier= Modifier.padding(2.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text ="손쓰 일기",
                    fontSize = 10.sp,
                    color = Color.LightGray,
                )
            }
        }
        Text(
            text ="송파 무인테니스\n24시간 더테니스존 장지점",
            fontSize = 10.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(2.dp))
        Row(){
            Image(
                modifier = Modifier
                    .size(20.dp)
                    .clip(shape = CircleShape),
                painter = painterResource(id = R.drawable.thum_no),
                contentDescription = "null",
            )
            Text(
                modifier = Modifier.padding(2.dp),
                text ="[서울 송파] 더테니스존 장지점",
                fontSize = 10.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview(){
    LiveReviewList()
}

data class LiveReview(
    val thumbnail: Int,
    val profileImg : Int,
    val profileName: String,
    val postingTitle: String,
    val reviewImg : Int,
    val reviewTitle : String
)
