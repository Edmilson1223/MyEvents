package com.example.myevents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myevents.databinding.ActivityCriarEventoBinding

class CriarEventoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCriarEventoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCriarEventoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.voltar.setOnClickListener {
            finish()
        }

    }
}