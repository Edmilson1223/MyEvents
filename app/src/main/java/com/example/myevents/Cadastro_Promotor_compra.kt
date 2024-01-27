package com.example.myevents

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myevents.dataBase.DBHelper
import com.example.myevents.databinding.ActivityCadastroPromotorCompraBinding

class Cadastro_Promotor_compra : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroPromotorCompraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCadastroPromotorCompraBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCadastro.setOnClickListener {
            val dbHelper = DBHelper(this)
            val values = ContentValues().apply {
                put("nome_promotor", binding.editNome.text.toString())
                put("cni", binding.editCni.text.toString())
                put("nif", binding.editNif.text.toString())
                put("email", binding.editEmail.text.toString())
                put("password", binding.editPassword.text.toString())
                put("nib", binding.editNib.text.toString())
            }
            val newRowId = dbHelper.insert("Promotor", values)/*newRowId é uma variável que armazena o ID da nova linha inserida na tabela. O método insert retorna o ID da nova linha inserida, que é armazenado na variável newRowId. Você pode usar esse ID para atualizar ou excluir a linha posteriormente. No exemplo que eu dei, a variável newRowId não é usada posteriormente, mas você pode usá-la se precisar.*/
            startActivity(Intent(this, LoginCliente::class.java))
        }
        binding.voltar.setOnClickListener {
            finish()
        }

    }


    }
