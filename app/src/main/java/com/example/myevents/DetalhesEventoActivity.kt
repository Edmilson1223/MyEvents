package com.example.myevents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myevents.databinding.ActivityDetalhesEventoBinding

class DetalhesEventoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesEventoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesEventoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dadosEvento = intent.getSerializableExtra("dados_evento") as ArrayList<ListaData>?

        if (dadosEvento != null) {
            // Agora você pode usar dadosEvento para exibir os detalhes na sua atividade
            // Exemplo: binding.textViewTitulo.text = dadosEvento[0].title
            binding.detailTitle.text = dadosEvento[0].title
            binding.detailDescricao.text = dadosEvento[0].desc

        }

        binding.btnAdBilhete.setOnClickListener {
            startActivity(Intent(this, AdquirirBilheteActivity::class.java))
        }

    }
}