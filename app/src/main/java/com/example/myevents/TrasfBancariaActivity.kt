package com.example.myevents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myevents.databinding.ActivityTrasfBancariaBinding

class TrasfBancariaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrasfBancariaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrasfBancariaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //abrir splash screen
        binding.voltar.setOnClickListener {
            finish()
        }
    }
}