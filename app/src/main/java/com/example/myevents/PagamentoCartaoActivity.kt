package com.example.myevents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myevents.databinding.ActivityPagamentoCartaoBinding

class PagamentoCartaoActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPagamentoCartaoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagamentoCartaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //abrir splash screen

    }
}