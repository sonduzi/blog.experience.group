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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blog_experiencegroup_project.R
import com.example.blog_experiencegroup_project.ui.component.MyAppFooter
import com.example.blog_experiencegroup_project.ui.components.MyAppBottomAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(/*navController: NavController*/) {
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = it.calculateBottomPadding()) // 하단 패딩을 계산하여 content를 BottomAppBar 위로 밀어냄
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "회원가입",
                        style = TextStyle(fontSize = 30.sp),
                        modifier = Modifier.padding(20.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = setEmail,
                        label = { Text("이메일") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    )
                    OutlinedTextField(
                        value = name,
                        onValueChange = setName,
                        label = { Text("이름") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        enabled = false
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
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
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    )
                    OutlinedTextField(
                        value = name,
                        onValueChange = setName,
                        label = { Text("비밀번호") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    )
                    OutlinedTextField(
                        value = name,
                        onValueChange = setName,
                        label = { Text("비밀번호 확인") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(color = Color(0xFFF7F6F6), shape = RoundedCornerShape(8.dp))
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
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = setAgree,
                            modifier = Modifier.padding(end = 1.dp) // 체크박스와 텍스트 사이 간격 조절
                        )
                        Text(
                            text = "서비스이용약관에 동의합니다.(필수)",
                        )
                        Text(
                            text = "내용보기",
                            modifier = Modifier.clickable {
                                // 내용보기 선택 시
                            }
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = setAgree,
                            modifier = Modifier.padding(end = 1.dp) // 체크박스와 텍스트 사이 간격 조절
                        )
                        Text(
                            text = "서비스이용약관에 동의합니다.(필수)",
                        )
                        Text(
                            text = "내용보기",
                            modifier = Modifier.clickable {
                                // 내용보기 선택 시
                            }
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = setAgree,
                            modifier = Modifier.padding(end = 1.dp) // 체크박스와 텍스트 사이 간격 조절
                        )
                        Text(
                            text = "서비스이용약관에 동의합니다.(필수)",
                        )
                        Text(
                            text = "내용보기",
                            modifier = Modifier.clickable {
                                // 내용보기 선택 시
                            }
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = setAgree,
                            modifier = Modifier.padding(end = 1.dp) // 체크박스와 텍스트 사이 간격 조절
                        )
                        Text(
                            text = "서비스이용약관에 동의합니다.(필수)",
                        )
                        Text(
                            text = "내용보기",
                            modifier = Modifier.clickable {
                                // 내용보기 선택 시
                            }
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = setAgree,
                            modifier = Modifier.padding(end = 1.dp) // 체크박스와 텍스트 사이 간격 조절
                        )
                        Text(
                            text = "서비스이용약관에 동의합니다.(필수)",
                        )
                        Text(
                            text = "내용보기",
                            modifier = Modifier.clickable {
                                // 내용보기 선택 시
                            }
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Checkbox(
                            checked = agree,
                            onCheckedChange = setAgree,
                            modifier = Modifier.padding(end = 1.dp) // 체크박스와 텍스트 사이 간격 조절
                        )
                        Text(
                            text = "서비스이용약관에 동의합니다.(필수)",
                        )
                        Text(
                            text = "내용보기",
                            modifier = Modifier.clickable {
                                // 내용보기 선택 시
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(
                        onClick = {
                            //navController.navigate("SignUp")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
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

@Preview
@Composable
fun DefaultPreview(){
    SignUpScreen()
}
