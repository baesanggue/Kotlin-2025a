package com.appweek12

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class CounterViewModel: ViewModel() { // ViewModel을 상속받아야 함
    private val _count = MutableStateFlow(0) // MutableStateFlow
    val count: StateFlow<Int> = _count.asStateFlow() // 변환하는 함수 필요

    fun increment(){
        _count.value += 1 // stateFlow의 장점 엘비스 필요 없음, 널값걱정 안해도 됨
    }
    fun decrement(){
        _count.value = (_count.value) - 1
    }
    fun reset(){
        _count.value = 0
    }
    fun incrementBy10() {
        _count.value += 10
    }
}