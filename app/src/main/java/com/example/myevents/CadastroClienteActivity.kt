package com.example.myevents

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myevents.databinding.ActivityCadastroClienteBinding

class CadastroClienteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroClienteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCadastroClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastro.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

    fun abrirPaginaCadastro(view: View){
        startActivity(Intent(this, LoginActivity::class.java))
    }
}