package com.appweek04

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GreetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge() 자동생성 제거
        setContentView(R.layout.activity_greet) //뷰 연동 코드

        val editTextName = findViewById<EditText>(R.id.editTextName) // 입력상자랑 변수 바인딩. 불변으로 선언
        val buttonGreet = findViewById<Button>(R.id.buttonGreet)
        val textViewGreeting = findViewById<TextView>(R.id.textViewGreeting)

        buttonGreet.setOnClickListener {
            val name = editTextName.text.toString().trim()

            var greeting: String =""

            if (name.isNotEmpty()) {
                greeting = "안녕하세요, ${name}님!"

            }
            else {
                greeting = "이름을 입력해주세요"
            }
            textViewGreeting.text = greeting
            textViewGreeting.visibility = View.VISIBLE
            Log.d("KotlinWeek04App", greeting)
        }
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets  안쓰니까 지워
    }
}
