package com.appweek12

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.appweek12.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CounterViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        

        setupObservers() // 얘가 관측하는 함수 / flow로 오면서 관찰하는 함수 변경
        setupListeners()

    }

    private fun setupObservers() {
//      viewModel.count.observe(this){
        lifecycleScope.launch { //쓰레드 돌리는 파트, 
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){ //live data의 observe 역할, 관측한다. 변화 생기면 스테이트 플로우에 알려서 반영
            viewModel.count.collect{
                count -> binding.textViewCount.text = count.toString()
                when{
                    count > 0 -> binding.textViewCount.setTextColor(Color.GREEN)
                    count < 0 -> binding.textViewCount.setTextColor(Color.RED)
                    else -> binding.textViewCount.setTextColor(Color.BLACK)
                }
            }
        }
//            count -> binding.textViewCount.text = count.toString()
        }
    }



    private fun setupListeners() {
        binding.buttonPlus.setOnClickListener{

            viewModel.increment() // viewmodel에서 제어함
        }
        binding.buttonMinus.setOnClickListener{

            viewModel.decrement()
        }
        binding.buttonReset.setOnClickListener{

            viewModel.reset()
        }
        binding.buttonPlus10.setOnClickListener{

            viewModel.incrementBy10()
        }
    }
    
}