package com.example.oplanodevida

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdicionarTarefaActivity : AppCompatActivity() {

    // Definir as tarefas
    private val tarefas = listOf(
        "Minuto heroico e oferecimento de obras",
        "Oração mental/Oração ao anjo e à Virgem",
        "Santa Missa",
        "Angelus ou Regina Caeli",
        "Visita ao Santíssimo Sacramento",
        "Santo Rosário",
        "Leitura espiritual",
        "Leitura dos Evangelhos",
        "Oração Mental",
        "Mortificação corporal",
        "Presença de Deus (jaculatórias)",
        "Exame de consciência",
        "Três Ave-Marias para alcançar a pureza",
        "Água benta"
    )

    private lateinit var spinnerTarefas: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_tarefa)

        spinnerTarefas = findViewById(R.id.spinnerTarefas)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tarefas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTarefas.adapter = adapter

        val buttonSalvar: Button = findViewById(R.id.buttonSalvar)
        buttonSalvar.setOnClickListener {
            salvarTarefa()
        }
    }

    private fun salvarTarefa() {
        val data = findViewById<EditText>(R.id.editTextData).text.toString()
        val tarefa = spinnerTarefas.selectedItem.toString()

        val sharedPreferences: SharedPreferences =
            getSharedPreferences("TAREFAS", Context.MODE_PRIVATE)
        val tarefasSalvas = sharedPreferences.getStringSet(data, mutableSetOf())

        tarefasSalvas?.add(tarefa)

        val editor = sharedPreferences.edit()
        editor.putStringSet(data, tarefasSalvas)
        editor.apply()

        Toast.makeText(applicationContext, "Tarefa adicionada para $data!", Toast.LENGTH_SHORT).show()
    }
}
