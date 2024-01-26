package com.example.myevents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myevents.databinding.ActivityAdquirirBilheteBinding

class AdquirirBilheteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdquirirBilheteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdquirirBilheteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCartao.setOnClickListener {
            startActivity(Intent(this, PagamentoCartaoActivity::class.java))
        }

        binding.btnTransfBancaria.setOnClickListener {
            startActivity(Intent(this, TrasfBancariaActivity::class.java))
        }
        binding.voltar.setOnClickListener {
            finish()
        }

    }
}