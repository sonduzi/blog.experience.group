package com.example.blog_experiencegroup_project.ui.screens

import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blog_experiencegroup_project.ui.theme.Purple500

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FindPasswordScreen(navController : NavController) {
    val (email, setEmail) = rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("아이디/비밀번호 찾기")}
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "회원가입 시 등록하신 이메일 주소를 입력해주세요.\n해당 이메일로 아이디와 비밀번호 정보를 보내드립니다.",
                style = TextStyle(color = Purple500, fontSize = 10.sp),
                modifier = Modifier.align(Alignment.Start)
            )
            OutlinedTextField(
                value = email,
                onValueChange = setEmail,
                label = {
                    Text(
                        text ="이메일주소(필수)"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )

            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = {
                    if(email.isNotEmpty()){
                        
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFFC107),
                    contentColor = Color.White
                )
            ){
                Text(
                    "정보 찾기"
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    navController.navigateUp()
                },
                modifier = Modifier
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFA7A7A7),
                    contentColor = Color(0xFF353535),
                ),

            ){
                Text(
                    "창닫기"
                )
            }
        }
    }
}
