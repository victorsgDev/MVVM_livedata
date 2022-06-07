package com.example.mvvm_livedata.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_livedata.model.QuoteModel
import com.example.mvvm_livedata.model.QuoteProvider

class QuoteViewModel:ViewModel() {
    val quoteModel=MutableLiveData<QuoteModel>() // encapsular modelo en un livedata

    fun randomQuote(){
        val currentQuote=QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }

}