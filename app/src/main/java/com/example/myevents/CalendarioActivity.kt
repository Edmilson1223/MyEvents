package com.example.myevents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myevents.databinding.ActivityCalendarioBinding

class CalendarioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalendarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.voltar.setOnClickListener {
            finish()
        }
    }
}