package com.example.blog_experiencegroup_project.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blog_experiencegroup_project.R
import com.example.blog_experiencegroup_project.ui.component.MyAppFooter
import com.example.blog_experiencegroup_project.ui.components.MyAppBottomAppBar
import com.example.blog_experiencegroup_project.ui.components.MyAppTable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    val (email, setEmail) = rememberSaveable {
        mutableStateOf("")
    }
    val (name, setName) = rememberSaveable {
        mutableStateOf("")
    }
    val (phone, setPhone) = rememberSaveable {
        mutableStateOf("")
    }
    val (nickname, setNickname) = rememberSaveable {
        mutableStateOf("")
    }
    val (agree, setAgree) = rememberSaveable {
        mutableStateOf(false)
    }
    val scrollState = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            MyAppBottomAppBar(
                onHomeClick = {
                   //navController.navigate("Home")
                },
                onCategoryClick = { /*TODO*/ },
                onAskClick = { /*TODO*/ },
                onAdAskClick = { /*TODO*/ },
                onLoginClick = {
                    //navController.navigate("Login")
                }
            )
        },
        content = {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = it.calculateBottomPadding()) // 하단 패딩을 계산하여 content를 BottomAppBar 위로 밀어냄
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    Text(
                        text = "회원가입",
                        style = TextStyle(fontSize = 30.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 50.dp),
                        textAlign = TextAlign.Center,
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = setEmail,
                        label = { Text("이메일") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    )
                    OutlinedTextField(
                        value = name,
                        onValueChange = setName,
                        label = { Text("이름") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        enabled = false
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 16.dp),
                    ) {
                        OutlinedTextField(
                            value = phone,
                            onValueChange = setPhone,
                            label = { Text("핸드폰 번호") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            enabled = false,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(1.dp))
                        Button(
                            onClick = { /* 버튼 클릭 시 수행할 작업 */ },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFFF6F00),
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .height(60.dp)
                                .padding(0.dp, 7.dp, 0.dp, 0.dp)
                                .align(CenterVertically),
                        ) {
                            Text(
                                "핸드폰 본인확인",
                                style = TextStyle(fontSize = 10.sp)
                            )
                        }
                    }
                    OutlinedTextField(
                        value = name,
                        onValueChange = setName,
                        label = { Text("닉네임") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    )
                    OutlinedTextField(
                        value = name,
                        onValueChange = setName,
                        label = { Text("비밀번호") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    )

                    OutlinedTextField(
                        value = name,
                        onValueChange = setName,
                        label = { Text("비밀번호 확인") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 5.dp)
                            .background(color = Color(0xFFF7F6F6),
                        shape = RoundedCornerShape(8.dp))
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Checkbox(
                                checked = agree,
                                onCheckedChange = setAgree,
                                modifier = Modifier.padding(end = 1.dp) // 체크박스와 텍스트 사이 간격 조절
                            )
                            Text(
                                text = "전체약관에 동의합니다.",
                                fontSize = 12.sp, // 텍스트 크기 설정
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .height(30.dp)
                    ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = setAgree,
                            modifier = Modifier
                                .width(24.dp)
                                .padding(end = 5.dp)
                        )
                        Text(
                            text = "서비스이용약관에 동의합니다.(필수)",
                            fontSize = 12.sp, // 텍스트 크기 설정
                            color = Color(0xFFAFAFAF)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "내용보기",
                            color = Color(0xFFAFAFAF),
                            fontSize = 10.sp, // 텍스트 크기 설정
                            textDecoration = TextDecoration.Underline, // 텍스트에 밑줄 추가
                            modifier = Modifier.clickable {
                                // 내용보기 선택 시
                            }
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .height(30.dp)
                    ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = setAgree,
                            modifier = Modifier
                                .width(24.dp)
                                .padding(end = 5.dp)
                        )
                        Text(
                            color = Color(0xFFAFAFAF),
                            text = "14세 이상입니다.(필수)",
                            fontSize = 12.sp, // 텍스트 크기 설정
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .height(30.dp)
                    ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = setAgree,
                            modifier = Modifier
                                .width(24.dp)
                                .padding(end = 5.dp)
                        )
                        Text(
                            color = Color(0xFFAFAFAF),
                            text = "개인정보 수집 및 이용에 동의합니다.(필수)",
                            fontSize = 12.sp, // 텍스트 크기 설정
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .height(30.dp)
                    ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = setAgree,
                            modifier = Modifier
                                .width(24.dp)
                                .padding(end = 5.dp)
                        )
                        Text(
                            color = Color(0xFFAFAFAF),
                            fontSize = 12.sp, // 텍스트 크기 설정
                            text = "신규 및 추천 캠페인 이벤트 정보등의 메일 수신에 동의합니다. (선택)",
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .height(30.dp)
                    ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = setAgree,
                            modifier = Modifier
                                .width(24.dp)
                                .padding(end = 5.dp)
                        )
                        Text(
                            text = "수집한 개인 정보의 이용 및 제3자 제공에 동의합니다.\n(필수)",
                            color = Color(0xFFAFAFAF),
                            fontSize = 12.sp, // 텍스트 크기 설정
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "내용보기",
                            fontSize = 10.sp, // 텍스트 크기 설정
                            color = Color(0xFFAFAFAF),
                            textDecoration = TextDecoration.Underline, // 텍스트에 밑줄 추가
                            modifier = Modifier.clickable {
                                // 내용보기 선택 시
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    MyAppTable()
                    Spacer(modifier = Modifier.height(40.dp))
                    Button(
                        onClick = {
                            //navController.navigate("SignUp")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .height(55.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFFFF6F00),
                            contentColor = Color.White,
                        ),
                    ) {
                        Text(
                            "회원가입"
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {
                            // 네이버 로그인
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .height(55.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Color(0xFF696969)
                        ),
                        border = BorderStroke(1.dp, Color(0xFFB9B9B9)),
                    ) {
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
                    Spacer(modifier = Modifier.height(50.dp))
                    MyAppFooter()
                }
            }
        }
    )
}


