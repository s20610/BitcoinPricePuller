package com.example.bitcoinapp

import android.inputmethodservice.Keyboard
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.bitcoinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainActivityViewModel.getCurrentPriceEveryMinute()
        adapter = RowAdapter(emptyList())
        binding.bitcoinRecyclerView.adapter = adapter
        setContentView(binding.root)
        mainActivityViewModel.bitcoinRow.observe(this) {
            adapter.bitcoinRows = it
            adapter.notifyDataSetChanged()
        }
    }
}