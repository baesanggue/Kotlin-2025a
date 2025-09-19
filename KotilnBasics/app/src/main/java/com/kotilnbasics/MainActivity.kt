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
        week02Functions()
        week03Classes()
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

private fun week02Functions(){
//    println("Week 02 : Functions")
//
//    fun greet(name: String) ="Hello, $name!"
//    println(greet("Android developer"))

    println("===Kotlin Function ===")
    //기본형태
    fun greet(name: String): String{
        return "Hello, $name"
    }
    // 단일표현식
    fun add(a: Int, b: Int) = a+b

    //기본 매개변수 주기
    fun introduce(name:String, age: Int = 19){
        println("My name is $name and I'm $age years old")
    }


    println(greet("Kotlin"))
    println("Sum = ${add(5,-71)}")
    introduce("kim",7)
    introduce("sam")


}
private fun week03Classes(){
    println("== Kotilin Classes ==")

    class Student{
        var name: String =""
        var age: Int = 0
        
        fun introduce(){
            println("HI, I'm $name and I'm $age years old")
        }
    }

    val student = Student()
    student.name = "Mirae"
    student.age = 21
    student.introduce()
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