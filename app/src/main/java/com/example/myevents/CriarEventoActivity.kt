package com.example.myevents

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.myevents.dataBase.DBHelper
import com.example.myevents.databinding.ActivityCriarEventoBinding
import java.util.Calendar

class CriarEventoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCriarEventoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCriarEventoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Adiciona um listener ao botão de upload de imagem
        binding.btnUploadImg.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }



        // Adiciona um listener ao botão de seleção de hora
        binding.btnHora.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                binding.textHora.text = "$hourOfDay:$minute"
            }, hour, minute, true)

            timePickerDialog.show()
        }

        // Adiciona um listener ao botão de seleção de data
        binding.btnDataInico.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                binding.textDataInicio.text = "$dayOfMonth/${month + 1}/$year"
            }, year, month, day)

            datePickerDialog.show()
        }

        // Adiciona um listener ao botão de criação de evento
        binding.btnCriarEvento.setOnClickListener {
            val dbHelper = DBHelper(this)
            val db = dbHelper.writableDatabase

            // Cria um ContentValues com os valores dos campos do formulário
            val values = ContentValues().apply {
                put("nome_evento", binding.editNomeEvento.text.toString())
                put("data_hora", binding.textDataInicio.text.toString() + " " + binding.textHora.text.toString())
                put("local", "local")
                put("descricao", binding.editDetalheEvento.text.toString())
                put("id_promotor", 1)
            }

            // Insere os valores na tabela Evento
            val newRowId = db?.insert("Evento", null, values)

            dbHelper.close()
        }
        binding.voltar.setOnClickListener{finish()}

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == RESULT_OK && data != null) {
            val selectedImage = data.data
            val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, selectedImage)
            binding.uploadImg.setImageBitmap(bitmap)
        }
    }
}
