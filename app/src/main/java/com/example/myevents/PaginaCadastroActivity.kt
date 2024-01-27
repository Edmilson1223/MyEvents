package com.example.myevents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myevents.databinding.ActivityPaginaCadastroBinding

class PaginaCadastroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaginaCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContaCliente.setOnClickListener {
            startActivity(Intent(this, CadastroClienteActivity::class.java))
        }

        binding.btnContaPromotor.setOnClickListener {
            startActivity(Intent(this, Cadastro_Promotor_compra::class.java))
        }

        binding.voltar.setOnClickListener {
            finish()
        }

    }
}