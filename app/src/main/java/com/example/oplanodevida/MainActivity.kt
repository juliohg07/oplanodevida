package com.example.oplanodevida

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Função para abrir a tela de adicionar tarefas (onClick do botão)
    fun abrirAdicionarTarefaActivity(view: View) {
        val intent = Intent(this, AdicionarTarefaActivity::class.java)
        startActivity(intent)
    }
}
