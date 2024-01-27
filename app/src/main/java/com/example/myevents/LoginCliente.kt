package com.example.myevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myevents.dataBase.DBHelper
import com.example.myevents.databinding.ActivityLoginClienteBinding

class LoginCliente : AppCompatActivity() {
    private lateinit var binding: ActivityLoginClienteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginClienteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
           val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val dbHelper = DBHelper(this)
            if (dbHelper.checkClienteLogin(email, password)) {
                startActivity(Intent(this, AdquirirBilheteActivity::class.java))
            } else {
                Toast.makeText(this, "Dados incoretos", Toast.LENGTH_SHORT).show()
            }
           // startActivity(Intent(this, AdquirirBilheteActivity::class.java))
        }
        binding.buttonCadastro.setOnClickListener {
            val i = Intent(this, PaginaCadastroActivity::class.java)
            startActivity(i)
        }
        binding.btnVoltar.setOnClickListener{
            finish()
        }
    }
}