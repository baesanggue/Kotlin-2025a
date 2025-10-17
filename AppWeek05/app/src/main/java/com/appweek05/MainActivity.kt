package com.appweek05

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // UI 컴포넌트
    private lateinit var buttonAdd: Button
    private lateinit var buttonClear: Button
    private lateinit var listView: ListView
    private lateinit var editTextStudent: EditText
    private lateinit var textViewCount: TextView

    // Collection
    private lateinit var studentList : ArrayList<String>
    private lateinit var adapter : ArrayAdapter<String>


    companion object {
        private const val TAG = "KotlinWeek05App"//태그 선언 //상수로 선언
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate : AppWeek05 started") //태그 기니까 따로 빼버리자, 상수처럼 사용 선언한 것을

        //함수들 만들어서 구현해야함
        setupViews()
        setupListView()
        setupListeners()

        addInitialData()
    }

    private fun setupViews(){
        buttonAdd = findViewById(R.id.buttonAdd)
        listView = findViewById(R.id.listViewStudents)
        editTextStudent = findViewById(R.id.editTextStudent)
        buttonClear = findViewById(R.id.buttonClear)
        textViewCount = findViewById(R.id.textViewCount)

        studentList = ArrayList()
        Log.d(TAG, "View initialized")
    }
    private fun setupListView(){
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentList)
        listView.adapter = adapter
        Log.d(TAG, "ListViews and Adapter setup completed")
    }
    private fun setupListeners(){
        buttonAdd.setOnClickListener{
            addStudent()
        }
        buttonClear.setOnClickListener{
             clearAllStudents()
        }
        listView.setOnItemLongClickListener{
            _,_, position, _-> removeStudent(position)
            true
        }
        listView.setOnItemClickListener { _, _, position, _ ->
            val studentName = studentList[position]
            Toast.makeText(
                this,
                "Selected : $studentName (Position : ${position+1})",
                Toast.LENGTH_SHORT //짧게 띄우는 옵션
            ).show() // 화면에 보이게
            Log.d(TAG, "Selected: $studentName at position $position") // 리스너 메세지
        }
        Log.d(TAG,"Event listeners setup completed")
    }

    private fun addStudent(){
        val studentName = editTextStudent.text.toString().trim()
        
        if (studentName.isEmpty()){
            Toast.makeText(this, "Please enter a student name", Toast.LENGTH_SHORT).show() // 이름 없으면 입력하라고 띄우기
            Log.d(TAG, "Attempted to add empty student name")
            return
        }
        if (studentList.contains(studentName)){
            Toast.makeText(this, "Student '$studentName' already exists", Toast.LENGTH_SHORT).show() // 리스트에 이미 이름이 존재할 경우 알림 띄우기
            Log.d(TAG, "Attempted to add duplicate student : $studentName")
            return
        }
        
        studentList.add(studentName) //백엔드에서 어레이 리스트에 추가 //화면에는 아직
        adapter.notifyDataSetChanged() //어뎁터에 변화 생겼다고 알림 보내기
        editTextStudent.text.clear() // 다음 사람 입력 받도록 지워주기
        
        updateStudentCount() // 개수 카운트 하는 함수 아직 안만듬
        Toast.makeText(this,"Added: $studentName", Toast.LENGTH_SHORT).show() // 학생 이름 추가되었다고 알림 띄움
        Log.d(TAG, "Added student: $studentName (Total: ${studentList.size}")
    }
    
    private fun clearAllStudents(){
        if (studentList.isEmpty()){
            Toast.makeText(this, "List is already empty", Toast.LENGTH_SHORT).show() // 이름 없으면 입력하라고 띄우기
            return
        }
        val count = studentList.size
        studentList.clear()
        adapter.notifyDataSetChanged()
        updateStudentCount()
        Toast.makeText(this, "Cleared all students (Total cleared: $count)",Toast.LENGTH_SHORT).show()
        Log.d(TAG,"Cleared all students (Total students : $count")
    }
    
    private fun updateStudentCount(){
        textViewCount.text = "Total Students : ${studentList.size}"
    }
    private fun removeStudent(position: Int){
        if (position >= 0 && position < studentList.size) //인덱스 범위 체크
        {
            val removedStudent = studentList.removeAt(position) // 실제 데이터 삭제
            adapter.notifyDataSetChanged() //어뎁터에 알림
            Toast.makeText(this, "Removed: $removedStudent",Toast.LENGTH_SHORT).show() // 삭제 알림 표기
            Log.d(TAG,"Removed student: $removedStudent (Remaining: ${studentList.size}) ") //로그로 남김
            
        }
    }
    
    private fun addInitialData(){
        val initialStudents = listOf("Kim", "Lee", "Park") // 초기 데이터 추가
        studentList.addAll(initialStudents)
        adapter.notifyDataSetChanged()
        updateStudentCount()
        Log.d(TAG, "Added initial data: $initialStudents")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume: Current student count : ${studentList.size}")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause: Saving state with ${studentList.size} students")
    }

}