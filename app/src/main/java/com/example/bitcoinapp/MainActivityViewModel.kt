package com.example.bitcoinapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bitcoinapp.api.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private var bitcoinRowsMutable: MutableLiveData<ArrayList<BitcoinRow>> = MutableLiveData()
    val bitcoinRow: LiveData<ArrayList<BitcoinRow>> = bitcoinRowsMutable
    private var bitcoinRowList: ArrayList<BitcoinRow> = ArrayList()

    fun getCurrentPriceEveryMinute() {
        viewModelScope.launch() {
            while (true) {
                getCurrentPrice()
                delay(60000)
            }
        }
    }

    private fun getCurrentPrice() {
        viewModelScope.launch {
            //Repository as an object because no dependency injection
            val response = Repository.getCurrentPrice()
            val bitcoinRow: BitcoinRow = BitcoinRow(
                response.body()!!.time.updated.toString(),
                response.body()!!.bpi.usd.toString()
            )
            handleListUpdate(bitcoinRow)
        }
    }

    private fun handleListUpdate(bitcoinRow: BitcoinRow) {
        bitcoinRowList.add(0, bitcoinRow)
        if (bitcoinRowList.size > 50) {
            bitcoinRowList.removeLast()
        }
        bitcoinRowsMutable.postValue(bitcoinRowList)
    }
}