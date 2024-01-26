package com.example.myevents

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myevents.databinding.ActivityCadastroPromotorBinding

class CadastroPromotorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroPromotorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCadastroPromotorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastro.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

    fun abrirPaginaLogin(view: View){
        startActivity(Intent(this, LoginActivity::class.java))
    }

}