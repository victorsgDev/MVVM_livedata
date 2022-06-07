package com.example.mvvm_livedata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvm_livedata.databinding.ActivityMainBinding
import com.example.mvvm_livedata.viewModel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel:QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text=currentQuote.quote
            binding.tvAuthor.text=currentQuote.author
        })

        binding.viewContainer.setOnClickListener(){
            quoteViewModel.randomQuote()
        }

    }
}