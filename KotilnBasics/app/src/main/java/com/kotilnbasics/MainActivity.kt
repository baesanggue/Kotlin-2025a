package com.kotilnbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotilnbasics.ui.theme.KotilnBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotilnBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        week02Variables()
    }
}

private fun week02Variables(){
//    println("Week 02 : Variables")
//
//    val courseName = "Mobile Programming"
//    //courseName = "IoT Programming"
//    //val 로 선언한건 재할당이 안됨
//
//    var week = 1
//    week = 2
//    // var로 선언한건 재할당 가능
//    println("Course : $courseName")
//    println("Week : $week")
    println("Kotlin Variables ==")

    // val(Immutable: 불변성) vs var(mutable: 가변성)
    val name = "Android"
    var version = 8

    println("Hello $name $version")

    val age: Int = 26
    val height: Double = 175.8
    val isStudent: Boolean = true

    println("Age : $age, Height: $height, Student : $isStudent")

   // var nickname: String = null  컴파일시 에러 잡음 널 허용이 안되는 스트링
    var nickname: String? = null // 얘는 널 허용되는 스트링이라 컴파일시 오류 안나옴
    nickname = "mirae"
    println("Nickname: $nickname, NicknameLength:  ${nickname?.length}")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotilnBasicsTheme {
        Greeting("Android")
    }
}