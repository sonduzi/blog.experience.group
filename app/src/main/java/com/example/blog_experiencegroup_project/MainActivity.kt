package com.example.blog_experiencegroup_project

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blog_experiencegroup_project.ui.components.MyAppBottomAppBar
import com.example.blog_experiencegroup_project.ui.screens.FindPasswordScreen
import com.example.blog_experiencegroup_project.ui.screens.HomeScreen
import com.example.blog_experiencegroup_project.ui.screens.LoginScreen
import com.example.blog_experiencegroup_project.ui.screens.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "Home"){
                composable(route="Home"){
                    HomeScreen(navController)
                }
                composable(route="Login"){
                    LoginScreen(navController)
                }
                composable(route="FindPassword"){
                    FindPasswordScreen(navController)
                }
                composable(route="SignUp"){
                    SignUpScreen(navController)
                }
            }
        }
    }
}
