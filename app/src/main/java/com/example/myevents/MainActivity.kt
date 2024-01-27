package com.example.myevents

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.myevents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val dados = ArrayList<ListaData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaEventos: ListView = findViewById(R.id.lista_eventos)
        dados.add(ListaData("Evento1", "kbchbhcsb", 200, R.drawable.cevin))
        dados.add(ListaData("Evento2", "kvfctc", 500, R.drawable.cevin))
        dados.add(ListaData("Evento3", "ouhg", 700, R.drawable.cevin))

        // Configurar o adaptador
        val adapter = ListaEventosAdapter(this, dados)

        listaEventos.adapter = adapter


        binding.listaEventos.setOnItemClickListener { parent, view, position, id ->
            // Obter o item clicado
            val itemClicado = dados[position]
            // Abrir uma nova atividade ou fazer algo com o item clicado
            val intent = Intent(this, DetalhesEventoActivity::class.java)
            intent.putExtra("evento_clicado", itemClicado)
            startActivity(intent)
        }



        binding.btnEvento.setOnClickListener {
            startActivity(Intent(this, SplashScreenCriarEventoActivity::class.java))
        }

        binding.btnCalendario.setOnClickListener {
            startActivity(Intent(this, CalendarioActivity::class.java))
        }

    }


}