package com.example.blog_experiencegroup_project.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blog_experiencegroup_project.R

@Composable
fun LoginScreen(navController: NavController){
    val (email, setEmail) = rememberSaveable {
        mutableStateOf("")
    }
    val (password, setPassword) = rememberSaveable {
        mutableStateOf("")
    }
    val (autoLogin, setAutoLogin) = rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "로그인",
            style = TextStyle(fontSize = 30.sp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = email,
            onValueChange = setEmail,
            label = { Text("이메일") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )
        OutlinedTextField(
            value = password,
            onValueChange = setPassword,
            label = { Text("비밀번호") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                if(email.isNotEmpty() && password.isNotEmpty()){
                    // 로그인 확인 필요
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFF16D6D),
                contentColor = Color.White
            )
        ){
            Text(
                "로그인"
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
            ){
                Checkbox(
                    checked = autoLogin,
                    onCheckedChange = setAutoLogin,
                    modifier = Modifier.size(10.dp)
                        .align(Alignment.CenterStart),
                    colors = CheckboxDefaults.colors( // 색상을 커스텀
                        checkedColor = Color(0xFFF16D6D), // 체크된 상태의 색상
                        uncheckedColor = Color(0xFFB9B9B9) // 체크되지 않은 상태의 색상
                    )
                )
            }
            Text(
                text = "자동 로그인",
                style = TextStyle(fontSize = 12.sp),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)

            ) {
                Text(
                    text = "비밀번호 찾기",
                    style = TextStyle(fontSize = 12.sp),
                    textAlign = TextAlign.End,
                    modifier = Modifier.clickable {
                        navController.navigate("FindPassword")
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {
                // 네이버 로그인
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color(0xFF696969)
            ),
            border = BorderStroke(1.dp, Color(0xFFB9B9B9)),
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.naver_logo),
                    contentDescription = "naverlogo",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
                Text(
                    text = "네이버 아이디로 시작하기",
                    style = MaterialTheme.typography.button
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                navController.navigate("SignUp")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color(0xFFF16D6D),
            ),
            border = BorderStroke(1.dp, Color(0xFFF16D6D)),
        ){
            Text(
                "회원가입"
            )
        }
    }
}

