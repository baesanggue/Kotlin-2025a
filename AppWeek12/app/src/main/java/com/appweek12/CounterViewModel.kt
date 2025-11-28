package com.appweek12

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// main에서 분리한 로직들을 넣을꺼임
// live data 사용
class CounterViewModel: ViewModel() { // ViewModel을 상속받아야 함
    private val _count = MutableLiveData(0) // 라이브 데이터 = 데이터가 변화가 되면 관측하고 있다가 값을 바꿔줌
    val count: LiveData<Int> = _count

    fun increment(){
        _count.value = (_count.value ?: 0) + 1
    }
    fun decrement(){
        _count.value = (_count.value ?: 0) - 1
    }
    fun reset(){
        _count.value = 0
    }
    fun incrementBy10() {
        _count.value = (_count.value ?: 0) + 10
    }
}