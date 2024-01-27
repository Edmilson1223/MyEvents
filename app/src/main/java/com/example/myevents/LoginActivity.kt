package com.example.myevents

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myevents.dataBase.DBHelper
import com.example.myevents.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val dbHelper = DBHelper(this)
            if (dbHelper.checkUserLogin(email, password)) {
                startActivity(Intent(this, CriarEventoActivity::class.java))
            } else {
                Toast.makeText(this, "Dados incoretos", Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonCadastro.setOnClickListener {
            val i = Intent(this, CadastroPromotorActivity::class.java)
            startActivity(i)
        }

        binding.voltar.setOnClickListener {
            finish()
        }

    }


}