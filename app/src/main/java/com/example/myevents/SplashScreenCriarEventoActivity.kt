package com.example.myevents

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.myevents.databinding.ActivitySplashScreenCriarEventoBinding

class SplashScreenCriarEventoActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashScreenCriarEventoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenCriarEventoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            // Este código será executado após o tempo definido acima
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            // Fecha a atividade atual
            finish()
        }, 1000)

    }
}