package com.example.blog_experiencegroup_project.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blog_experiencegroup_project.R

@Composable
fun MyAppBottomAppBar(
    onHomeClick: () -> Unit,
    onCategoryClick: () -> Unit,
    onAskClick: () -> Unit,
    onAdAskClick: () -> Unit,
    onLoginClick: () -> Unit,
){
    BottomAppBar(
        backgroundColor = Color.White
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = onHomeClick
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_home_24),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = "홈",
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }

            IconButton(
                onClick = onCategoryClick
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_apps_24),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = "카테고리",
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }

            IconButton(
                onClick = onAskClick
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_mail_24),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = "1:1문의",
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }

            IconButton(
                onClick = onAdAskClick
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_auto_awesome_24),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = "광고문의",
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }

            IconButton(
                onClick = onLoginClick
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_login_24),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = "로그인",
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}