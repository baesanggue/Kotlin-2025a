package com.kotilnbasics

import android.hardware.camera2.CameraExtensionSession.StillCaptureLatency
import android.os.Bundle
import android.util.Log
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
        //week02Variables()
        //week02Functions()
        week03Classes()
        //week03Collections()
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
    //println("== Kotilin Classes ==")

    //tag = 태깅 정보 이걸로 로그창에서 태그로 검색 가능
    Log.d("KotlinWeek03", "== Kotlin Classes ==")
    class Person(val name: String, var age: Int){
        fun introduce() {
            Log.d("KotlinWeek03", "안녕하세요, $name ($age 세) 입니다")
        }
        // 후위 연산도 가능
        fun birthday(){
            age++
            Log.d("KotlinWeek03", "$name 의 생일 이제 $age 세...")
        }
    }
    val person1 = Person("홍길동", 27)
    person1.introduce()
    person1.birthday()

    // 원래 생성자는 constructer 표기 해야하는데 생략가능 굳이 표현하자면
    // 상속이 가능하게 할려면 open 이라는 키워드가 필요
    open class Animal(var species: String){
        var weight: Double = 0.0
        constructor(species: String, weight: Double) : this(species){
            this.weight = weight
            Log.d("KotlinWeek03", "$species 의 무게 : $weight kg")
        }

        open fun makeSound(){
            Log.d("KotlinWeek03", "$species 가 소리를 냅니다.")
        }
    }
    val puppy = Animal("개", 10.5)
    puppy.makeSound()

    // open 안쓰면 오버라이드도 안됨.. 상속 개념 및 상속 불가 개념 : 자바의 final 개념 이해 필요
    // 자바 클래스 상속 개념 다 이용 가능 open 사용하면 상속 가능.. 안쓰면 final처럼 상수 혹은 불변 클래스 및 메소드가 되버림

    class Dog(species : String , weight : Double, val breed : String) : Animal(species, weight){
        override fun makeSound(){
            Log.d("KotlinWeek03", "$breed($species)가 멍멍 짓습니다")
        }
    }
    val dog = Dog("개", 12.5,"웰시코기")
    dog.makeSound()

    data class Book(val title : String, val auther: String, val pages: Int)

    //data 클래스의 특징.. 자바의 tostring 처럼 커스텀 해서 자동으로 만들어줌? 이런 느낌?

    val book1 = Book("코틀린 입문", "Kim", 400)
    val book2 = Book("코틀린 입문", "Kim", 400)
    // 이거 포인터 개념으로 같은 객체임
    Log.d("KotlinWeek03", "book1 == book2: ${book1 == book2}") //같은 객체라 트루 나옴
    Log.d("KotlinWeek03", "book1: $book1")
// data class 사용시 tostring 형태로 나옴 .fun이라는 메소드가 없어도 tostring 형태로 나옴 /.


//
//    class Student{
//        var name: String =""
//        var age: Int = 0
//
//        fun introduce(){
//            println("HI, I'm $name and I'm $age years old")
//        }
//    }
//
//    val student = Student()
//    student.name = "Mirae"
//    student.age = 21
//    student.introduce()
//
//    //클래스 만들고 생성자 사용
//    data class Person(val name: String, val age: Int)
//
//    val person1 = Person("Kim", age = 23)
//    val person2 = Person("Kim", age = 23)
//
//    println("Person1: $person1")
//    println("Equal? : ${person1 == person2}")
}
private fun week03Collections(){
    println("=== Kotlin Collections ===")

    
    // 값을 바꿀 수 없는 리스트
    val fruits = listOf("apple", "banana", "orange")
    println("Fruits: $fruits")

    //fruits.add() 값을 바꿀 수 없어서 오류

    // 값을 바꿀수 있는 리스트
    val mutableFruits = mutableListOf("kiwi", "watermelon")
    println("MutableFruits : $mutableFruits")
    mutableFruits.add("banana")
    println("MutableFruits : $mutableFruits")

    //map (딕셔너리 형태)
    val scores = mapOf("Kim" to 100, "Park" to 97, "Lee" to 99) //왼쪽이 키 오른쪽이 밸류
    println("Scores : $scores")

    //범위기반 반복문

    for(fruit in fruits){
        println(" I like $fruit")
    }
    // 뮤타블이든 아니든 상관 없다..
    for(fruit in mutableFruits){
        println(" I like $fruit")
    }

    //foreach 는 자바랑 다르게 중 괄호로 열기
    scores.forEach{(name, score) -> println("$name scored $score")}
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